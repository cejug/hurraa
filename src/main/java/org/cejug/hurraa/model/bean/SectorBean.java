package org.cejug.hurraa.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cejug.hurraa.model.Sector;

@Stateless
public class SectorBean extends AbstractBean<Sector> {

    @PersistenceContext
    private EntityManager manager;

    public SectorBean() {
        super(Sector.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.manager;
    }
}
