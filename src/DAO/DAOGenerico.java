/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author sebastian
 */
public class DAOGenerico {

    EntityManagerFactory entityManager = null;

    public DAOGenerico(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManager;
    }

    public void setEntityManager(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager getEntityManager() {
        return this.getEntityManagerFactory().createEntityManager();
    }

    public void guardar(Object object) {
        EntityManager EntityManager = null;
        try {
            EntityManager = getEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.persist(object);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("No se pudo crear correctamente");
        } finally {
            if (EntityManager != null) {
                EntityManager.close();
            }
        }
    }

    public Object Buscar(int id, String tabla, String buscado) {
        EntityManager EntityManager = null;
        try {
            EntityManager = getEntityManager();
            Query query = EntityManager.createQuery("select c FROM " + tabla + " c where c." + buscado + "=:nombre");
            query.setParameter("nombre", id);
            return (Object) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (EntityManager != null) {
                EntityManager.close();
            }
        }
    }

 

    public List BuscarTodos(String tabla) {
        EntityManager EntityManager = null;
        try {
            EntityManager = getEntityManager();
            Query query = EntityManager.createQuery("SELECT c FROM " + tabla + " c ");
            System.out.println(query.toString());
            return (List) query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (EntityManager != null) {
                EntityManager.close();
            }
        }
    }


    public void Editar(Object objeto) {
        EntityManager EntityManager = null;
        try {
            EntityManager = getEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(objeto);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (EntityManager != null) {
                EntityManager.close();
            }
        }
    }

    public void eliminar(Object objeto) {
        EntityManager EntityManager = null;
        try {
            EntityManager = getEntityManager();
            EntityManager.getTransaction().begin();
            objeto = EntityManager.merge(objeto);
            EntityManager.remove(objeto);
            EntityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (EntityManager != null) {
                EntityManager.close();
            }
        }
    }


}
