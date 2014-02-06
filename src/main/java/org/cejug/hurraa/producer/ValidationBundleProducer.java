package org.cejug.hurraa.producer;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.core.SafeResourceBundle;

@RequestScoped
public class ValidationBundleProducer {
    
    @Inject
    private Locale locale;
    
    @Produces
    @ValidationMessages
    public ResourceBundle getBundle(){
        return  new SafeResourceBundle( ResourceBundle.getBundle("ValidationMessages" , locale ) );
    }
    
    
}
