package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.Sector;

@Stateless
public class SectorBean {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Sector> list() {
		return manager.createQuery("from Sector").getResultList();
	}

	public void insert(Sector sector) {
		manager.persist(sector);
	}

	public Sector findById(Long id) {
		return manager.find(Sector.class, id);
	}

	public void update(Sector sector) {
		manager.merge(sector);
	}

	public void delete(Sector sector) {
		manager.remove(manager.merge(sector));
	}

}
