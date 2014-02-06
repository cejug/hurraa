package org.cejug.hurraa.controller;

import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import javax.validation.Valid;

import org.cejug.hurraa.model.EquipmentModel;
import org.cejug.hurraa.model.EquipmentType;
import org.cejug.hurraa.model.bean.EquipmentModelBean;
import org.cejug.hurraa.model.bean.EquipmentTypeBean;
import org.cejug.hurraa.producer.ValidationMessages;
import org.cejug.hurraa.validation.EquipmentModelNameAvailable;

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
    
    private Result result;
    private EquipmentModelBean equipmentModelBean;
    private EquipmentTypeBean equipmentTypeBean;
    private ResourceBundle bundle;
    
    @Deprecated
    public EquipmentModelController() {  }
    
    @Inject
    public EquipmentModelController( Result result , EquipmentModelBean equipmentModelBean, EquipmentTypeBean equipmentTypeBean , @ValidationMessages ResourceBundle bundle ) {
        this.result = result;
        this.equipmentModelBean = equipmentModelBean;
        this.equipmentTypeBean = equipmentTypeBean;
        this.bundle = bundle;
    }

    @Path(value = { "", "/" })
    public void index() {
        result.forwardTo(EquipmentModelController.class).list();
    }

    @Path("form")
    public void form() {
        result.include("types" , equipmentTypeBean.findAll() );
    }

    @Path("form/{id}")
    public void form(Long id) {
        EquipmentModel equipmentModel = equipmentModelBean.findById(id);
        result.include( equipmentModel );
        result.include("types" , equipmentTypeBean.findAll() );
    }

    @Post("insert")
    public void insert(@Valid  EquipmentModel equipmentModel
            , Validator validator ) {
        verifyIfSelectedEquipmentType(equipmentModel , validator);
        validator.onErrorForwardTo( EquipmentModelController.class ).form();
        
        equipmentModelBean.insert(equipmentModel);
        result.redirectTo(EquipmentModelController.class).list();
    }

    @Get("list")
    public void list() {
        result.include("equipmentModels", equipmentModelBean.findAll());
    }

    @Post("update")
    public void update(@Valid EquipmentModel equipmentModel , Validator validator) {
        verifyIfSelectedEquipmentType(equipmentModel , validator);
        validator.onErrorForwardTo( EquipmentModelController.class ).form();
        
        equipmentModelBean.update( equipmentModel );
        result.redirectTo(EquipmentModelController.class).list();
    }

    @Path("delete/{equipmentType.id}")
    public void delete(EquipmentModel equipmentModel) {
        equipmentModelBean.delete(equipmentModel);
        result.redirectTo(EquipmentModelController.class).list();
    }
    
    protected void verifyIfSelectedEquipmentType(EquipmentModel equipmentModel , Validator validator ){
        if(equipmentModel.getEquipmentType() == null || equipmentModel.getEquipmentType().getId() == null ){
            validator.add( new SimpleMessage( "equipmentModel.equipmentType.id" , bundle.getString("equipmentModel.equipmentType.required") ) );
        }
    }
    
}