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

import org.cejug.hurraa.model.ProblemType;
import org.cejug.hurraa.model.bean.ProblemTypeBean;
import org.cejug.hurraa.validation.Unique;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path("problem-type")
@Controller
public class ProblemTypeController {

	private Result result;
	private ProblemTypeBean problemTypeBean;	
	private ResourceBundle messagesBundle;

	@Deprecated
	public ProblemTypeController() {};

	@Inject
	public ProblemTypeController(Result result, ProblemTypeBean problemTypeBean, ResourceBundle messagesBundle) {
		this.result = result;
		this.problemTypeBean = problemTypeBean;
		this.messagesBundle = messagesBundle;		
	}
	
	@Path(value = { "", "/" })
	public void index() {
		result.forwardTo(this).list();
	}
	
	@Path("form")
	public void form() {}
	
	@Path("form/{id}")
	public void form(Long id) {
		ProblemType problemType = problemTypeBean.findById(id);
		result.include(problemType);
	}
	
	@Post("insert")
	public void insert(
			@Valid
			@Unique(identityPropertyName = "id", propertyName = "name", entityClass = ProblemType.class)			
			ProblemType problemType, Validator validator) {
		
		validator.onErrorForwardTo(this).form();
		
		problemTypeBean.insert(problemType);
		
		result.include("message", messagesBundle.getString("insert.success"));
		result.redirectTo(this).list();
	}
	
	@Post
	@Path("update")
	public void update(
			@Valid
			@Unique(identityPropertyName = "id", propertyName = "name", entityClass = ProblemType.class)
			ProblemType problemType, Validator validator) {
		validator.onErrorForwardTo(this).form();
		
		problemTypeBean.update(problemType);
		
		result.include("message", messagesBundle.getString("update.success"));		
		result.redirectTo(this).list();		
	}
	
	@Get("list")
	public void list() {
		result.include("problemTypes", problemTypeBean.findAll());		
	}
	
	@Path("delete/{problemType.id}")
	public void delete(ProblemType problemType) {
		problemTypeBean.delete(problemType);
		
		result.include("message", messagesBundle.getString("delete.success"));
		result.redirectTo(this).list();
	}
}
