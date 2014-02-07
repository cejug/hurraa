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
package org.cejug.hurraa.controller;

import javax.inject.Inject;

import org.cejug.hurraa.model.Manufacturer;
import org.cejug.hurraa.model.bean.ManufacturerBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Path("manufacturer")
@Controller
public class ManufacturerController {

	private Result result;
	private ManufacturerBean manufacturerBean;

	public ManufacturerController() {
	}

	@Inject
	public ManufacturerController(Result result,
			ManufacturerBean manufacturerBean) {
		this.result = result;
		this.manufacturerBean = manufacturerBean;
	}
	
	@Path(value = { "", "/" })
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
	public void insert(Manufacturer manufacturer) {
		manufacturerBean.insert(manufacturer);
		result.redirectTo("/manufacturer/list");
	}

	@Get
	@Path("list")
	public void list() {
		result.include("manufacturers", manufacturerBean.findAll());
	}

	@Post
	@Path("update")
	public void update(Manufacturer manufacturer) {
		manufacturerBean.update(manufacturer);
		result.redirectTo(ManufacturerController.class).list();
	}

	@Path("delete/{manufacturer.id}")
	public void delete(Manufacturer manufacturer) {
		manufacturerBean.delete(manufacturer);
		result.redirectTo(ManufacturerController.class).list();
	}
}