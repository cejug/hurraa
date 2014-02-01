package org.cejug.hurraa.validation;

import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Outjector;
import br.com.caelum.vraptor.view.ValidationViewsFactory;

@Specializes 
@RequestScoped
public class CejugValidator extends DefaultValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultValidator.class);

	private final Result result;
	private final ValidationViewsFactory viewsFactory;
	private final Outjector outjector;
	private final Proxifier proxifier;

	protected CejugValidator() {
		this(null, null, null, null, null);
	}

	@Inject
	public CejugValidator(Result result, ValidationViewsFactory factory, Outjector outjector, Proxifier proxifier, ResourceBundle bundle) {
		super(  result , factory , outjector , proxifier , bundle );
		this.result = result;
		this.viewsFactory = factory;
		this.outjector = outjector;
		this.proxifier = proxifier;
	}

	@Override
	public <T extends View> T onErrorUse(Class<T> view) {
		if (!hasErrors()) {
			return new MockResult(proxifier).use(view); //ignore anything, no errors occurred
		}
		
		List<Message> errors = getErrors();
		result.include("errors", new CejugErrorMap( getErrors() ) );
		outjector.outjectRequestMap();
		
		logger.debug("there are errors on result: {}", errors);
		return viewsFactory.instanceFor(view, errors);
	}

}
