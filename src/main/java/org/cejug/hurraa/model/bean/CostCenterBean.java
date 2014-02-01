package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.CostCenter;

@Stateless
public class CostCenterBean extends AbstractBean<CostCenter> {

	@PersistenceContext
	private EntityManager manager;
	
	public CostCenterBean() {
		super(CostCenter.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.manager;
	}
	
}
