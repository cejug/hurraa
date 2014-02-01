package org.cejug.hurraa.controller;

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

	public UserController() {
		super();
	}

	@Inject
	public UserController(Result result, UserBean userBean) {
		this.result = result;
		this.userBean = userBean;
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
		result.redirectTo(UserController.class).list();
	}

	@Path("delete/{user.id}")
	public void delete(User user) {
		userBean.delete(user);
		result.redirectTo(UserController.class).list();
	}
}