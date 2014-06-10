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

import org.cejug.hurraa.model.Occurrence;
import org.cejug.hurraa.model.User;
import org.cejug.hurraa.model.bean.OccurrenceBean;
import org.cejug.hurraa.model.bean.OccurrenceStateBean;
import org.cejug.hurraa.model.bean.ProblemTypeBean;
import org.cejug.hurraa.model.bean.SectorBean;
import org.cejug.hurraa.model.bean.UserBean;
import org.cejug.hurraa.model.bean.exception.NoChangeInOccurrenceException;
import org.cejug.hurraa.producer.ValidationMessages;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Path("update-occurrence")
@Controller
public class UpdateOccurrenceController {
	
	private Result result;
	private OccurrenceBean occurrenceBean;
	private ResourceBundle messageBundle;
	private ResourceBundle validationBundle;
	private ProblemTypeBean problemTypeBean;
	private OccurrenceStateBean occurrenceStateBean;
	private SectorBean sectorBean;
	
	@Inject
	private UserBean userBean;

	@Deprecated
	public UpdateOccurrenceController() {
	}

	@Inject
	public UpdateOccurrenceController(Result result, OccurrenceBean occurrenceBean,
			ProblemTypeBean problemTypeBean,
			SectorBean sectorBean,
			OccurrenceStateBean occurrenceStateBean,
			ResourceBundle messagesBundle,
			@ValidationMessages ResourceBundle validationBundle) {
		this.result = result;
		this.occurrenceBean = occurrenceBean;
		this.occurrenceStateBean = occurrenceStateBean;
		this.messageBundle = messagesBundle;
		this.validationBundle = validationBundle;
		this.problemTypeBean = problemTypeBean;
		this.sectorBean = sectorBean;
	}
	
	@Get
	@Path("/{occurrenceId}")
	public void form(Long occurrenceId){
		Occurrence occurrence = occurrenceBean.findById(occurrenceId);
		if(occurrence != null){
		    result.include("problemTypes", problemTypeBean.findAll());
			result.include("sectors", sectorBean.findAll());
			result.include("occurrenceStates" , occurrenceStateBean.findAll() );
			result.include("occurrence", occurrence);
		}
	}
	
	@Post
	@Path("/{occurrenceId}")
	public void processForm(Long occurrenceId, String updateNote, @Valid Occurrence occurrence, Validator validator) {
		validator.onErrorForwardTo(OpenOccurrenceController.class).form();
		
		//TODO Add user from the session
		User user = userBean.findAll().get(0);
		try {
			occurrenceBean.updateOccurrence( occurrence  , updateNote , user);
			result.include("message" , messageBundle.getString("updateOccurrence.messageSuccess") );
		} catch (NoChangeInOccurrenceException e) {
			result.include("errorMessage" , messageBundle.getString("updateOccurrence.messageError") );
		}
		result.forwardTo(this.getClass()).form( occurrenceId );
	}
	
	@Get
	@Path("/")
	public void form() {
		
	}
}
