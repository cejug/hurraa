package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.Manufacturer;

@Stateless
public class ManufacturerBean extends AbstractBean<Manufacturer> {

	@PersistenceContext
	private EntityManager manager;

	public ManufacturerBean() {
		super(Manufacturer.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.manager;
	}
}
