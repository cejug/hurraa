package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Model class to other beans
 *
 * @author Daniel Cunha (danielsoro@gmail.com)
 *
 */
public abstract class AbstractBean<T> {

    private Class<T> entityClass;

    public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void insert(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T findById(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Returns all persisted instances of the given entity. Use it with extreme
     * precaution.
     */
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder()
                .createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
