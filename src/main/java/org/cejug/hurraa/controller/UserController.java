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

import org.cejug.hurraa.model.User;
import org.cejug.hurraa.model.bean.UserBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path("user")
@Controller
public class UserController {

	private Result result;
	private UserBean userBean;
	private ResourceBundle messagesBundle;

	public UserController() {
		super();
	}

	@Inject
	public UserController(Result result, UserBean userBean , ResourceBundle bundle) {
		this.result = result;
		this.userBean = userBean;
		this.messagesBundle = bundle;
	}
	
	@Path(value = { "", "/" })
    public void index() {
        result.forwardTo(UserController.class).list();
    }

	@Path("form")
	public void form() {

	}

	@Path("form/{id}")
	public void form(Long id) {
		User user = userBean.findById(id);
		result.include(user);
	}

	@Post
	@Path("insert")
	public void insert(@Valid User user, Validator validator) {
		validator.onErrorForwardTo(UserController.class).form();
		
		userBean.insert(user);
		result.include("message", messagesBundle.getString("insert.success") );
		result.redirectTo("/user/list");
	}

	@Get
	@Path("list")
	public void list() {
		result.include("users", userBean.findAll());
	}

	@Post
	@Path("update")
	public void update(@Valid User user, Validator validator) {
		validator.onErrorForwardTo(UserController.class).form();
		
		userBean.update(user);
		result.include("message", messagesBundle.getString("update.success") );
		result.redirectTo(UserController.class).list();
	}

	@Path("delete/{user.id}")
	public void delete(User user) {
		userBean.delete(user);
		result.include("message", messagesBundle.getString("delete.success") );
		result.redirectTo(UserController.class).list();
	}
}