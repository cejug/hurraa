/*
* This file is part of Hurraa.
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
