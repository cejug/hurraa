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

import org.cejug.hurraa.model.OccurrenceState;
import org.cejug.hurraa.model.bean.OccurrenceStateBean;
import org.cejug.hurraa.validation.EquipmentTypeInUse;
import org.cejug.hurraa.validation.Unique;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path("occurrence-state")
public class OccurrenceStateController {

	private Result result;
	private OccurrenceStateBean occurrenceStateBean;
	private ResourceBundle messagesBundle;

	@Deprecated
	public OccurrenceStateController() {
	}
	
	@Inject
	public OccurrenceStateController(Result result , OccurrenceStateBean occurrenceStateBean , ResourceBundle messagesBundle ){
		this.result = result;
		this.occurrenceStateBean = occurrenceStateBean;
		this.messagesBundle  = messagesBundle;
	}

	@Path(value = { "", "/" })
	public void index() {
		result.forwardTo( this.getClass() ).list();
	}

	@Path("form")
	public void form() {

	}

	@Path("form/{id}")
	public void form(Integer id) {
		OccurrenceState occurrenceState = occurrenceStateBean.findById(id);
		result.include(occurrenceState);
	}

	@Post("insert")
	public void insert(
		@Valid 
		@Unique(identityPropertyName="id" , propertyName="name" , entityClass=OccurrenceState.class)
		OccurrenceState occurrenceState, Validator validator) {
		validator.onErrorForwardTo( this.getClass() ).form();

		occurrenceStateBean.insert(occurrenceState);
		result.include("message", messagesBundle.getString("insert.success"));
		result.redirectTo( this.getClass() ).list();
	}

	@Get("list")
	public void list() {
		result.include("occurrenceStates", occurrenceStateBean.findAll());
	}

	@Post("update")
	public void update(
		@Valid
		@Unique(identityPropertyName="id" , propertyName="name" , entityClass=OccurrenceState.class)
		OccurrenceState occurrenceState, Validator validator) {
		validator.onErrorForwardTo(this.getClass()).form();

		occurrenceStateBean.update(occurrenceState);
		result.include("message", messagesBundle.getString("update.success"));
		result.redirectTo(this.getClass()).list();
	}

	@Path("delete/{occurrenceState.id}")
	public void delete(OccurrenceState occurrenceState,
			Validator validator) {
		validator.onErrorForwardTo(this.getClass()).list();
		occurrenceStateBean.delete(occurrenceState);
		result.include("message", messagesBundle.getString("delete.success"));
		result.redirectTo(this.getClass()).list();
	}

}
