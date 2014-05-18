/*
* Hurraa is a web application conceived to manage resources
* in companies that need manage IT resources. Create issues
* and purchase IT materials. Copyright (C) 2014 CEJUG.
*
* Hurraa is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Hurraa is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Hurraa. If not, see http://www.gnu.org/licenses/gpl-3.0.html.
*
*/
package org.cejug.hurraa.validation.impl;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.cejug.hurraa.validation.Unique;

/**
 * 
 * @author Efraim Gentil (efraim.gentil@gmail.com)
 * 
 */
public class UniqueValidator implements ConstraintValidator< Unique  ,  Object > {
    
//  @PersistenceContext
//  private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    
    private String fieldName;
    private String identityFieldName;
    @SuppressWarnings("rawtypes")
    private Class entityClass;
    
    @Override
    public void initialize(Unique constraintAnnotation) {
        fieldName = constraintAnnotation.propertyName();
        identityFieldName = constraintAnnotation.identityPropertyName();
        entityClass = constraintAnnotation.entityClass();
    }
    
    @Override
    public boolean isValid(Object value,
            ConstraintValidatorContext context) {
        return validateUniqueness(value, context);
    }
    
    public boolean validateUniqueness(Object value,
            ConstraintValidatorContext context){
        try {
            Field field = value.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object fieldValue = field.get(value);
            
            field = value.getClass().getDeclaredField( identityFieldName );
            field.setAccessible(true);
            Object identityFieldValue = field.get(value);
            
            
            StringBuilder sb = new StringBuilder( String.format( "FROM %s a WHERE  a.%s = :fieldValue" , entityClass.getSimpleName() , fieldName ) );
            if(identityFieldValue != null)
               sb.append( String.format( " AND a.%s != :identifyFieldValue"  , identityFieldName ) );   
            
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            
            Query query = entityManager.createQuery( sb.toString() );
            query.setMaxResults(1);
            query.setParameter( "fieldValue", fieldValue );
            if(identityFieldValue != null)
                query.setParameter( "identifyFieldValue", identityFieldValue );
            
            return query.getResultList().isEmpty();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        
        return false;
    }

}