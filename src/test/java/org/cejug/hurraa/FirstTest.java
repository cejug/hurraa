package org.cejug.hurraa;

import org.cejug.hurraa.controller.ManufacturerController;
import org.cejug.hurraa.model.bean.HurraaBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class FirstTest {

//    @Deployment
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class)
//                .addClass(ManufacturerController.class)
////                .addClass(HurraaBean.class)
////                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }

//    @Inject
//    ManufacturerController mc;
    
    @Test
    public void first_test() {
        //mc.list();
    }

}
