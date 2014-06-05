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

import org.cejug.hurraa.model.Manufacturer;
import org.cejug.hurraa.model.bean.ManufacturerBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path("manufacturer")
@Controller
public class ManufacturerController {

    @Inject
    private Result result;
    @Inject
    private ManufacturerBean manufacturerBean;
    @Inject
    private ResourceBundle messagesBundle;

    @Path(value = {"", "/"})
    public void index() {
        result.forwardTo(ManufacturerController.class).list();
    }

    @Path("form")
    public void form() {

    }

    @Path("form/{id}")
    public void form(Long id) {
        Manufacturer manufacturer = manufacturerBean.findById(id);
        result.include(manufacturer);
    }

    @Post
    @Path("insert")
    public void insert(@Valid Manufacturer manufacturer, Validator validator) {
        validator.onErrorRedirectTo(ManufacturerController.class).form();

        manufacturerBean.insert(manufacturer);
        result.include("message", messagesBundle.getString("insert.success"));
        result.redirectTo("/manufacturer/list");
    }

    @Get
    @Path("list")
    public void list() {
        result.include("manufacturers", manufacturerBean.findAll());
    }

    @Post
    @Path("update")
    public void update(@Valid Manufacturer manufacturer, Validator validator) {
        validator.onErrorRedirectTo(ManufacturerController.class).form();

        manufacturerBean.update(manufacturer);
        result.include("message", messagesBundle.getString("update.success"));
        result.redirectTo(ManufacturerController.class).list();
    }

    @Path("delete/{manufacturer.id}")
    public void delete(Manufacturer manufacturer) {
        manufacturerBean.delete(manufacturer);
        result.include("message", messagesBundle.getString("delete.success"));
        result.redirectTo(ManufacturerController.class).list();
    }
}