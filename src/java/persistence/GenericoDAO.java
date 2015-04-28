/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 1146322
 */
public interface GenericoDAO<E> extends Serializable {
    public void inserir(E e);
    public void alterar(E e);
    public void remover(E e);
    public List<E> listar();

}
