package org.cejug.hurraa.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.cejug.hurraa.validation.impl.UniqueValidator;

@Target({ ElementType.TYPE , ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueValidator.class })
@ReportAsSingleViolation
@Documented
public @interface Unique {
    
    String message() default "{already_in_use}";
    
    String propertyName();
    
    String identityPropertyName();
    
    @SuppressWarnings("rawtypes")
    Class entityClass();
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
}
