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

import org.cejug.hurraa.model.Sector;
import org.cejug.hurraa.model.bean.SectorBean;
import org.cejug.hurraa.validation.Unique;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path(value = "sector")
@Controller
public class SectorController {

    private Result result;
    private SectorBean sectorBean;
    private ResourceBundle messagesBundle;
    
    @Deprecated
    public SectorController() {	}
    
    @Inject
    public SectorController(Result result, SectorBean sectorBean , ResourceBundle messagesBundle ) {
    	this.result = result;
    	this.sectorBean = sectorBean;
    	this.messagesBundle = messagesBundle;
	}

    @Path(value = { "", "/" })
    public void index() {
        result.forwardTo(SectorController.class).list();
    }

    @Path("form")
    public void form() {

    }

    @Path("form/{id}")
    public void form(Long id) {
        Sector sector = sectorBean.findById(id);
        result.include(sector);
    }

    @Post("/insert")
    public void insert(
            @Valid
            @Unique(propertyName = "name" , identityPropertyName="id" , entityClass = Sector.class )
            Sector sector , Validator validator) {
    	validator.onErrorForwardTo( SectorController.class ).form();
    	
        sectorBean.insert(sector);
        result.include("message", messagesBundle.getString("insert.success") );
        result.redirectTo(SectorController.class).list();
    }

    @Get
    @Path("list")
    public void list() {
        result.include("sectors", sectorBean.findAll());
    }

    @Post
    @Path("update")
    public void update(
            @Valid 
            @Unique(propertyName = "name" , identityPropertyName="id" , entityClass = Sector.class )
            Sector sector , Validator validator) {
    	validator.onErrorForwardTo( SectorController.class ).form();
    	
        sectorBean.update(sector);
        result.include("message", messagesBundle.getString("update.success") );
        result.redirectTo(SectorController.class).list();
    }

    @Path("delete/{sector.id}")
    public void delete(Sector sector) {
        sectorBean.delete(sector);
        result.include("message", messagesBundle.getString("delete.success") );
        result.redirectTo(SectorController.class).list();
    }
}