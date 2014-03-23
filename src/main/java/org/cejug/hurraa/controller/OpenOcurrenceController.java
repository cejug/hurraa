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

import org.cejug.hurraa.model.bean.OcurrenceBean;
import org.cejug.hurraa.model.bean.ProblemTypeBean;
import org.cejug.hurraa.model.bean.SectorBean;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Path("open-ocurrence")
@Controller
public class OpenOcurrenceController {
	
	private Result result;
	private OcurrenceBean ocurrenceBean;
	private ResourceBundle messageBundle;
	
	@Inject
	private ProblemTypeBean problemTypeBean;
	@Inject 
	private SectorBean sectorBean;
	
	@Deprecated
	public OpenOcurrenceController() {
	}
	
	@Inject
	public OpenOcurrenceController(Result result , OcurrenceBean ocurrenceBean , ResourceBundle messagesBundle) {
		this.result = result;
		this.ocurrenceBean = ocurrenceBean;
		this.messageBundle = messagesBundle;
	}
	
	@Get
	@Path("/")
	public void form(){
		result.include("problemTypes" , problemTypeBean.findAll() );
		result.include("sectors",  sectorBean.findAll() );
	}
	
	@Post
	public void processForm(){
		
		result.forwardTo(OpenOcurrenceController.class).form();
	}
	
	
	
}