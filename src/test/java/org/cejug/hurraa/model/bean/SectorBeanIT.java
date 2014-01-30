package org.cejug.hurraa.model.bean;

import java.util.List;

import javax.inject.Inject;

import org.cejug.hurraa.model.Sector;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class SectorBeanIT {
	
	private Logger logger = LoggerFactory.getLogger(SectorBeanIT.class);
	
	@Inject
	private SectorBean sectorBean;
	
	@Deployment
	public static Archive<?> setup(){
		return ShrinkWrap.create( WebArchive.class )
				.addPackage( SectorBean.class.getPackage() )
				.addPackage( Sector.class.getPackage() )
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void shouldTestSomethingUsefull(){
		logger.trace(" Test running ok ");
		logger.info(" SectorBean haduken " , sectorBean );
		
		List<Sector> sectors = sectorBean.findAll();
	}
	
}
