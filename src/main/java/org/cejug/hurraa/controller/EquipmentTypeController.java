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
package org.cejug.hurraa.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.cejug.hurraa.model.EquipmentType;
import org.cejug.hurraa.model.bean.EquipmentTypeBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path("equipment-type")
@Controller
public class EquipmentTypeController {
	
	private Result result;
    private EquipmentTypeBean equipmentTypeBean;
    
    @Deprecated
    public EquipmentTypeController() {	}
    
    @Inject
    public EquipmentTypeController( Result result , EquipmentTypeBean equipmentTypeBean  ) {
    	this.result = result;
    	this.equipmentTypeBean = equipmentTypeBean;
	}

    @Path(value = { "", "/" })
    public void index() {
        result.forwardTo(EquipmentTypeController.class).list();
    }

    @Path("form")
    public void form() {

    }

    @Path("form/{id}")
    public void form(Long id) {
        EquipmentType equipmentType = equipmentTypeBean.findById(id);
        result.include( equipmentType );
    }

    @Post("insert")
    public void insert(@Valid EquipmentType equipmentType , Validator validator ) {
    	validator.onErrorForwardTo( EquipmentTypeController.class ).form();
    	
    	equipmentTypeBean.insert(equipmentType);
        result.redirectTo(EquipmentTypeController.class).list();
    }

    @Get("list")
    public void list() {
        result.include("equipmentTypes", equipmentTypeBean.findAll());
    }

    @Post("update")
    public void update(@Valid EquipmentType equipmentType , Validator validator) {
    	validator.onErrorForwardTo( EquipmentTypeController.class ).form();
    	
    	equipmentTypeBean.update( equipmentType );
        result.redirectTo(EquipmentTypeController.class).list();
    }

    @Path("delete/{equipmentType.id}")
    public void delete(EquipmentType equipmentType) {
        equipmentTypeBean.delete(equipmentType);
        result.redirectTo(EquipmentTypeController.class).list();
    }
	
}
