package org.cejug.hurraa.controller;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.cejug.hurraa.model.Manufacturer;
import org.cejug.hurraa.model.bean.HurraaBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Path("manufacturer")
@Controller
public class ManufacturerController {
	
	@Inject private Result result;
	
	@EJB
	private HurraaBean hurraaBean;
	
	@Path("form")
	public void form() {
		
	}
	
	@Path("form/{id}")
	public void form(Long id) {
		Manufacturer manufacturer = hurraaBean.findById(Manufacturer.class, id);
		result.include(manufacturer);
	}
	
	@Post
	@Path("insert")
	public void insert(Manufacturer manufacturer) {
	    hurraaBean.insert(manufacturer);
		result.redirectTo("/manufacturer/list");
	}
	
	@Get
	@Path("list")
	public void list() {
		result.include("manufacturers", hurraaBean.findAll(Manufacturer.class));
	}
	
	@Post
	@Path("update")
	public void update(Manufacturer manufacturer) {
	    hurraaBean.update(manufacturer);
		result.redirectTo(ManufacturerController.class).list();
	}
	
	@Path("delete/{manufacturer.id}")
	public void delete(Manufacturer manufacturer) {
	    hurraaBean.delete(Manufacturer.class, manufacturer.getId());
		result.redirectTo(ManufacturerController.class).list();
	}
}