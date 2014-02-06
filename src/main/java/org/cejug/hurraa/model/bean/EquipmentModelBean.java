package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.cejug.hurraa.model.EquipmentModel;

@Stateless
public class EquipmentModelBean extends AbstractBean<EquipmentModel> {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public EquipmentModelBean() {
        super(EquipmentModel.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public boolean isNameAvailable(String name){
        TypedQuery<EquipmentModel> query = getEntityManager()
                    .createNamedQuery( "FIND_BY_NAME", EquipmentModel.class );
        query.setParameter("name", name);
        return query.getResultList().isEmpty();
    }

}
