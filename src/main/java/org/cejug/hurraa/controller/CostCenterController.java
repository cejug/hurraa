package org.cejug.hurraa.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.cejug.hurraa.model.CostCenter;
import org.cejug.hurraa.model.Sector;
import org.cejug.hurraa.model.bean.CostCenterBean;
import org.cejug.hurraa.model.bean.SectorBean;
import org.cejug.hurraa.util.ValidationUtil;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.validator.beanvalidation.MethodValidator;

@Path("cost-center")
@Controller
public class CostCenterController {
	
	private Result result;
    private CostCenterBean costCenterBean;
    
    @Deprecated
    public CostCenterController() {	}
    
    @Inject
    public CostCenterController( Result result , CostCenterBean costCenterBean  ) {
    	this.result = result;
    	this.costCenterBean = costCenterBean;
	}

    @Path(value = { "", "/" })
    public void index() {
        result.forwardTo(CostCenterController.class).list();
    }

    @Path("form")
    public void form() {

    }

    @Path("form/{id}")
    public void form(Long id) {
        CostCenter costCenter = costCenterBean.findById(id);
        result.include( costCenter );
    }

    @Post("insert")
    public void insert(@Valid CostCenter costCenter , Validator validator ) {
    	validator.onErrorForwardTo( CostCenterController.class ).form();
    	
    	costCenterBean.insert(costCenter);
        result.redirectTo(CostCenterController.class).list();
    }

    @Get("list")
    public void list() {
        result.include("costCenters", costCenterBean.findAll());
    }

    @Post("update")
    public void update(@Valid CostCenter costCenter , Validator validator) {
    	validator.onErrorForwardTo( CostCenterController.class ).form();
    	
    	costCenterBean.update( costCenter );
        result.redirectTo(CostCenterController.class).list();
    }

    @Path("delete/{sector.id}")
    public void delete(CostCenter costCenter) {
    	costCenterBean.delete(costCenter);
        result.redirectTo(CostCenterController.class).list();
    }
	
}
