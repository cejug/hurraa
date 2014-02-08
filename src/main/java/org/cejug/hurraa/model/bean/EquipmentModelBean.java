/*
* Hurraa is a web application conceived to manage resources
* in companies that need manage IT resources. Create issues
* and purchase IT materials. Copyright (C) 2014 CEJUG.
*
* Hurraa is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Hurraa is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Hurraa. If not, see http://www.gnu.org/licenses/gpl-3.0.html.
*
*/
package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.cejug.hurraa.model.EquipmentModel;
import org.cejug.hurraa.model.EquipmentType;

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
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public boolean isEquipmentTypeInUse(EquipmentType equipmentType){
        Query query = getEntityManager().createNamedQuery("EQUIPMENTTYPE_IN_USE" , EquipmentModel.class );
        query.setParameter("equipmentType", equipmentType );
        return query.getResultList().isEmpty();
    }

}
