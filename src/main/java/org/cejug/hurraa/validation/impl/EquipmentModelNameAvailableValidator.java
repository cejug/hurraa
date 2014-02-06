package org.cejug.hurraa.validation.impl;

import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.cejug.hurraa.model.bean.EquipmentModelBean;
import org.cejug.hurraa.validation.EquipmentModelNameAvailable;

public class EquipmentModelNameAvailableValidator implements ConstraintValidator< EquipmentModelNameAvailable , String> {
    
    @Inject
    private EquipmentModelBean equipmentModelBean;
    
    @Inject
    private ResourceBundle bundle;
    
    @Override
    public void initialize(EquipmentModelNameAvailable constraintAnnotation) {
//        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value,
            ConstraintValidatorContext context) {
        return equipmentModelBean.isNameAvailable( value );
    }

}
