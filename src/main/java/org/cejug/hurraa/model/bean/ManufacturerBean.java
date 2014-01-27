package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.Manufacturer;

@Stateless
public class ManufacturerBean {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Manufacturer> list() {
		return manager.createQuery("from Manufacturer").getResultList();
	}

	public void insert(Manufacturer manufacturer) {
		manager.persist(manufacturer);
	}

	public Manufacturer findById(Long id) {
		return manager.find(Manufacturer.class, id);
	}

	public void update(Manufacturer manufacturer) {
		manager.merge(manufacturer);
	}

	public void delete(Manufacturer manufacturer) {
		manager.remove(manager.merge(manufacturer));
	}
}
