package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HurraaBean {

    @PersistenceContext
    private EntityManager em;

    public <T> T insert(T t) {
        this.em.persist(t);
        this.em.flush();
        return t;
    }

    public <T> T findById(Class<T> t, Object id) {
        return (T) this.em.find(t, id);
    }

    public void delete(Class klass, Object id) {
        Object ref = em.getReference(klass, id);
        this.em.remove(ref);
    }

    public <T> T update(T t) {
        return (T) this.em.merge(t);
    }

    public <T> List<T> findAll(String jpql, Class<T> klass) {
        return this.em.createQuery(jpql, klass).getResultList();
    }

    public <T> List<T> findWithLimit(String jpql, Class<T> klass, int limit) {
        return this.em.createQuery(jpql, klass).setMaxResults(limit).getResultList();
    }
    
    public void removeWithParameter(String jpql, String param, Class klass) {
        em.createQuery(jpql, klass).setParameter(1, param).executeUpdate();
    }
   
}

