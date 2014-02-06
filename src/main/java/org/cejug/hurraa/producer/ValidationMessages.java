package org.cejug.hurraa.producer;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Target({ METHOD , FIELD , PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidationMessages {
    
    
}
