package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.User;

@Stateless
public class UserBean extends AbstractBean<User> {

	@PersistenceContext
	private EntityManager manager;
	
	public UserBean() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.manager;
	}
}
