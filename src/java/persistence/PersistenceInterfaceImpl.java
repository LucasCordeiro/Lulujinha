/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author RodrigoSoldi
 */
public class PersistenceInterfaceImpl implements PersistenceInterface{

    private final EntityManagerFactory factory;
    private final EntityManager manager;    
    private EntityTransaction transaction;

    public PersistenceInterfaceImpl() {
        this.factory = Persistence.createEntityManagerFactory("WebApplication1PU");
        manager = factory.createEntityManager();
    }
    
    @Override
    public Serializable save(Object o) {
        try{
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(o);
            transaction.commit();
            return (Serializable) o;
        }catch(PersistenceException e){
            transaction.rollback();
        }
        return null;
    }

    @Override
    public void delete(Object o) {
        try{
            transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(o);
            transaction.commit();
        }catch(PersistenceException e){
            transaction.rollback();
        }
    }

    @Override
    public Serializable update(Object o) {
         try{
            transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(o);
            transaction.commit();
            return (Serializable) o;
        }catch(PersistenceException e){
            transaction.rollback();
        }
        return null;
    }

    @Override
    public List<Serializable> list(Class classe) {
            try{
            CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();            
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(classe);
            Root objectos = criteriaQuery.from(classe);
            criteriaQuery.select(objectos);                        
            return manager.createQuery(criteriaQuery).getResultList();
        }catch(PersistenceException e){
        }
        return null;
    }

    @Override
    public Serializable getById(Class classe, Long primaryKey) {
        try{
            Serializable object = (Serializable)manager.find(classe, primaryKey);
            return object;
        }catch(PersistenceException e){            
        }
        
        return null;
    }
    
}
