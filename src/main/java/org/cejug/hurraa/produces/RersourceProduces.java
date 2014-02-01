package org.cejug.hurraa.produces;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cejug.hurraa.qualifiers.JavaxValidator;

/**
 * @author Daniel Cunha (danielsoro@gmail.com)
 */
public class RersourceProduces {

	@Produces
	@JavaxValidator
	public Validator getValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}
}
