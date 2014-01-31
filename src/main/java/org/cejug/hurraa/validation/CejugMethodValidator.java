package org.cejug.hurraa.validation;

import java.util.Iterator;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Path.Node;
import javax.validation.Path.ParameterNode;

import com.google.common.base.Joiner;

import br.com.caelum.vraptor.http.ValuedParameter;
import br.com.caelum.vraptor.validator.beanvalidation.MethodValidator;

@Specializes
@ApplicationScoped
public class CejugMethodValidator extends MethodValidator {
	
	@Deprecated
	protected CejugMethodValidator() {
		this(null, null, null);
	}

	@Inject
	public CejugMethodValidator(Locale locale, MessageInterpolator interpolator, javax.validation.Validator bvalidator) {
		super(locale , interpolator, bvalidator);
	}
	
	@Override
	protected String extractCategory(ValuedParameter[] params, ConstraintViolation<Object> v) {
		Iterator<Node> property = v.getPropertyPath().iterator();
		property.next();
		ParameterNode parameterNode = property.next().as(ParameterNode.class);
		int index = parameterNode.getParameterIndex();
		String argName = "arg" + index;
		int indexOfArg = v.getPropertyPath().toString().indexOf(argName);
		return Joiner.on(".").join(v.getPropertyPath()).substring( indexOfArg ).replace("arg" + index, params[index].getName());
	}
	
}
