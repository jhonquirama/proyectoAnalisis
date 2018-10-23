/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DAOGenerico;
import java.util.List;
import DAO.Conexion;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public abstract class CtlAbstracto<T> {
    
    

    private Class<T> entityClass;

    public static Conexion con = new Conexion();
    public static DAOGenerico dao = new DAOGenerico(con.getFactory());

    public CtlAbstracto(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        dao.guardar(entity);
    }

    public void edit(T entity) {
        dao.Editar(entity);
    }

    public void remove(T entity) {
        dao.eliminar(entity);
    }

    public T find(Object id) {
        return dao.getEntityManagerFactory().createEntityManager().find(entityClass, id);
    }

    public T findXName(String nombre) {
        return dao.getEntityManagerFactory().createEntityManager().find(entityClass, nombre);
    }

    public List<T> findAll(String tabla) {
        return dao.BuscarTodos(tabla);
    }

    
}
