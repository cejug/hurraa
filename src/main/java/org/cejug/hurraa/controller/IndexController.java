package org.cejug.hurraa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject private Result result;
	
	@Path("/")
	public void index() {
		result.include("variable", "Hi!!!");
	}
	
	@Path("listar")
	public void listar() {
		result.include("text", "User Teste");
	}
	
}