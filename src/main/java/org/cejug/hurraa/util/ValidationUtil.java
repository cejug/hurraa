package org.cejug.hurraa.util;

import java.util.Set;

import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;


@Stateless
public class ValidationUtil {
	
	public Validator validateBean( String prefix , Object validationTarget , Validator validator ){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator beanValidator = factory.getValidator();
    	Set<ConstraintViolation<Object>> constrainsErrors =  beanValidator.validate(validationTarget);
    	
    	prefix = updatePrefix(prefix);
    	for (ConstraintViolation<Object> constrain : constrainsErrors) {
    		Path propertyPath = constrain.getPropertyPath();
    		String category = prefix + propertyPath.toString();
			validator.add( new SimpleMessage( category , constrain.getMessage() ));
		}
		return validator;
	}
	
	protected String updatePrefix(String prefix){
		if(prefix != null && !prefix.trim().isEmpty()){
			return prefix + ".";
		}
		return "";
	}
	
}
