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

import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.validation.Valid;

import org.cejug.hurraa.model.EquipmentModel;
import org.cejug.hurraa.model.bean.EquipmentModelBean;
import org.cejug.hurraa.model.bean.EquipmentTypeBean;
import org.cejug.hurraa.producer.ValidationMessages;
import org.cejug.hurraa.validation.Unique;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path("equipment-model")
@Controller
public class EquipmentModelController {

    @Inject
    private Result result;
    @Inject
    private EquipmentModelBean equipmentModelBean;
    @Inject
    private EquipmentTypeBean equipmentTypeBean;
    @Inject
    private ResourceBundle validationBundle;
    @Inject
    @ValidationMessages
    private ResourceBundle messagesBundle;

    @Path(value = {"", "/"})
    public void index() {
        result.forwardTo(EquipmentModelController.class).list();
    }

    @Path("form")
    public void form() {
        result.include("types", equipmentTypeBean.findAll());
    }

    @Path("form/{id}")
    public void form(Long id) {
        EquipmentModel equipmentModel = equipmentModelBean.findById(id);
        result.include(equipmentModel);
        result.include("types", equipmentTypeBean.findAll());
    }

    @Post("insert")
    public void insert(@Valid
                       @Unique(propertyName = "name", identityPropertyName = "id", entityClass = EquipmentModel.class)
                       EquipmentModel equipmentModel, Validator validator) {
        verifyIfSelectedEquipmentType(equipmentModel, validator);
        validator.onErrorForwardTo(EquipmentModelController.class).form();

        equipmentModelBean.insert(equipmentModel);
        result.include("message", messagesBundle.getString("insert.success"));
        result.redirectTo(EquipmentModelController.class).list();
    }

    @Get("list")
    public void list() {
        result.include("equipmentModels", equipmentModelBean.findAll());
    }

    @Post("update")
    public void update(@Valid
                       @Unique(propertyName = "name", identityPropertyName = "id", entityClass = EquipmentModel.class)
                       EquipmentModel equipmentModel, Validator validator) {
        verifyIfSelectedEquipmentType(equipmentModel, validator);
        validator.onErrorForwardTo(EquipmentModelController.class).form();

        equipmentModelBean.update(equipmentModel);
        result.include("message", messagesBundle.getString("update.success"));
        result.redirectTo(EquipmentModelController.class).list();
    }

    @Path("delete/{equipmentModel.id}")
    public void delete(EquipmentModel equipmentModel) {
        equipmentModelBean.delete(equipmentModel);
        result.include("message", messagesBundle.getString("delete.success"));
        result.redirectTo(EquipmentModelController.class).list();
    }

    protected void verifyIfSelectedEquipmentType(EquipmentModel equipmentModel, Validator validator) {
        if (equipmentModel.getEquipmentType() == null || equipmentModel.getEquipmentType().getId() == null) {
            validator.add(new SimpleMessage("equipmentModel.equipmentType.id", validationBundle.getString("equipmentModel.equipmentType.required")));
        }
    }

}