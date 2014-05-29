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
import org.cejug.hurraa.model.bean.OccurrenceBean;
import org.cejug.hurraa.model.bean.OccurrenceStateBean;
import org.cejug.hurraa.model.bean.ProblemTypeBean;
import org.cejug.hurraa.model.bean.SectorBean;
import org.cejug.hurraa.model.bean.UserBean;
import org.cejug.hurraa.producer.ValidationMessages;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path("open-ocurrence")
@Controller
public class OpenOccurrenceController {

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
	public OpenOccurrenceController() {
	}

	@Inject
	public OpenOccurrenceController(Result result, OccurrenceBean occurrenceBean,
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
	@Path("/")
	public void form() {
		result.include("problemTypes", problemTypeBean.findAll());
		result.include("sectors", sectorBean.findAll());
		result.include("occurrenceStates" , occurrenceStateBean.findAll() );
	}

	@Post
	@Path("/")
	public void processForm(@Valid Occurrence occurrence, Validator validator) {
		verifyIfSelectedSector(occurrence, validator);
		verifyIfSelectedProblemType(occurrence, validator);
		verifyIfSelectedOccurrenceState(occurrence, validator);
		validator.onErrorForwardTo(OpenOccurrenceController.class).form();
		
		//TODO Add user from the session
		occurrence.setUser( userBean.findAll().get(0) );
		
		occurrenceBean.insert(occurrence);
		result.include("message" , messageBundle.getString("openOccurrence.messageSuccess") );
		result.forwardTo(OpenOccurrenceController.class).form();
	}

	private void verifyIfSelectedOccurrenceState(Occurrence occurrence,
			Validator validator) {
		if (occurrence.getOccurrenceState() == null
				|| occurrence.getOccurrenceState().getId() == null) {
			validator
					.add(new SimpleMessage("occurrence.occurrenceState", validationBundle
							.getString("occurrence.occurrenceState.required")));
		}
	}

	protected void verifyIfSelectedSector(Occurrence occurrence,
			Validator validator) {
		if (occurrence.getSector() == null
				|| occurrence.getSector().getId() == null) {
			validator
					.add(new SimpleMessage("occurrence.sector", validationBundle
							.getString("occurrence.sector.required")));
		}
	}
	
	protected void verifyIfSelectedProblemType(Occurrence occurrence,
			Validator validator) {
		if (occurrence.getProblemType() == null
				|| occurrence.getProblemType().getId() == null) {
			validator
					.add(new SimpleMessage("occurrence.problemType", validationBundle
							.getString("occurrence.problemType.required")));
		}
	}

}