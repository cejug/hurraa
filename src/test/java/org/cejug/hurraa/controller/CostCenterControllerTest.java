package org.cejug.hurraa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidatorFactory;

import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import br.com.caelum.iogi.reflection.Target;
import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.caelum.vraptor.http.iogi.VRaptorDependencyProvider;
import br.com.caelum.vraptor.http.iogi.VRaptorInstantiator;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.validator.beanvalidation.ValidatorFactoryCreator;

public class CostCenterControllerTest {
	
	@Test
	public void shouldValidateCostCenter(){
		List<Message> m;
//		new VRaptorInstantiator().instantiate( DefaultValidator.class ,  null);
//		Validator validator = new DefaultValidator();
//		validator.check( false ,  new SimpleMessage( "name" , "can't be null") );
	}
	
	
}
