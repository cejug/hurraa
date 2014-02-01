package org.cejug.hurraa.util;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Path;

import org.cejug.hurraa.qualifiers.JavaxValidator;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Stateless
public class ValidationUtil {

	@Inject
	@JavaxValidator
	private javax.validation.Validator beanValidator;

	public Validator validateBean(String prefix, Object validationTarget,
			Validator validator) {

		Set<ConstraintViolation<Object>> constrainsErrors = beanValidator
				.validate(validationTarget);

		prefix = updatePrefix(prefix);
		for (ConstraintViolation<Object> constrain : constrainsErrors) {
			Path propertyPath = constrain.getPropertyPath();
			String category = prefix + propertyPath.toString();
			validator.add(new SimpleMessage(category, constrain.getMessage()));
		}
		return validator;
	}

	protected String updatePrefix(String prefix) {
		if (prefix != null && !prefix.trim().isEmpty()) {
			return prefix + ".";
		}
		return "";
	}

}
