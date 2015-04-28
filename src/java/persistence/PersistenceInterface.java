/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author RodrigoSoldi
 */
public interface PersistenceInterface {
    Serializable save(Object o);
    void delete(Object o);
    Serializable update(Object o);
    Serializable getById(Class classe, Long primaryKey);
    List<Serializable> list(Class classe);
}