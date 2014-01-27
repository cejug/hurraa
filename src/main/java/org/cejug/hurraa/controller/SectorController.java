package org.cejug.hurraa.controller;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import javax.servlet.jsp.tagext.ValidationMessage;

import org.cejug.hurraa.model.Sector;
import org.cejug.hurraa.model.bean.SectorBean;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.validator.beanvalidation.ValidatorCreator;

@Path(value = "sector")
@Controller
public class SectorController {
	
	@Inject	private Result result;
	@Inject private HttpServletRequest request;
	
	@Inject
	private Validator validator;
	
	@EJB
	private SectorBean sectorBean;
	
	@Path(value = { "" , "/" })
	public void index(){
		result.forwardTo( SectorController.class ).list();
	}
	
	@Path("form")
	public void form() {
		
	}

	@Path("form/{id}")
	public void form(Long id) {
		Sector sector = sectorBean.findById(id);
		result.include(sector);
	}

	@Post
	@Path("insert")
	public void insert(Sector sector) {
//		validator.check( sector.getName() != null  , new SimpleMessage("erro" , "name.invalid"));
//		validator.onErrorForwardTo( SectorController.class ).form();
		sectorBean.insert( sector );
		result.redirectTo( SectorController.class ).list();
	}

	@Get
	@Path("list")
	public void list() {
		result.include("sectors", sectorBean.list());
	}

	@Post
	@Path("update")
	public void update(Sector sector) {
		sectorBean.update(sector );
		result.redirectTo( SectorController.class).list();
	}

	@Path("delete/{sector.id}")
	public void delete(Sector sector) {
		sectorBean.delete(sector);
		result.redirectTo(SectorController.class).list();
	}

}
