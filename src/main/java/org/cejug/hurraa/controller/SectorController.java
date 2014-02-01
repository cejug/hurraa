package org.cejug.hurraa.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.cejug.hurraa.model.Sector;
import org.cejug.hurraa.model.bean.SectorBean;

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
    
    @Deprecated
    public SectorController() {	}
    
    @Inject
    public SectorController(Result result, SectorBean sectorBean ) {
    	this.result = result;
    	this.sectorBean = sectorBean;
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
    public void insert(@Valid Sector sector , Validator validator) {
    	validator.onErrorForwardTo( SectorController.class ).form();
    	
        sectorBean.insert(sector);
        result.redirectTo(SectorController.class).list();
    }

    @Get
    @Path("list")
    public void list() {
        result.include("sectors", sectorBean.findAll());
    }

    @Post
    @Path("update")
    public void update(@Valid Sector sector , Validator validator) {
    	validator.onErrorForwardTo( SectorController.class ).form();
    	
        sectorBean.update(sector);
        result.redirectTo(SectorController.class).list();
    }

    @Path("delete/{sector.id}")
    public void delete(Sector sector) {
        sectorBean.delete(sector);
        result.redirectTo(SectorController.class).list();
    }
}