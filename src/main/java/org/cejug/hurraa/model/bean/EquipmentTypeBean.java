package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.EquipmentType;

@Stateless
public class EquipmentTypeBean extends AbstractBean<EquipmentType> {

	@PersistenceContext
	private EntityManager manager;
	
	public EquipmentTypeBean() {
		super(EquipmentType.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.manager;
	}
	
}
