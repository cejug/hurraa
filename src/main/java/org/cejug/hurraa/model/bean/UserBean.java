package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.User;

@Stateless
public class UserBean {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<User> list() {
		return manager.createQuery("from User").getResultList();
	}

	public void insert(User user) {
		manager.persist(user);
	}

	public User findById(Long id) {
		return manager.find(User.class, id);
	}

	public void update(User user) {
		manager.merge(user);
	}

	public void delete(User user) {
		manager.remove( manager.merge(user) );
	}
	
}
