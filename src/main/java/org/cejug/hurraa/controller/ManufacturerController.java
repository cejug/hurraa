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