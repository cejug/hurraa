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

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.cejug.hurraa.model.Occurrence;
import org.cejug.hurraa.model.bean.OccurrenceBean;
import org.cejug.hurraa.producer.ValidationMessages;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path(value = "occurrences")
@Controller
public class ListOccurrenceController {
	
	private Result result;
	private OccurrenceBean occurrenceBean;
	private ResourceBundle validationBundle;
	
	@Deprecated
	public ListOccurrenceController() {	}

	@Inject
	public ListOccurrenceController(Result result, OccurrenceBean occurrenceBean , @ValidationMessages ResourceBundle validationBundle) {
		super();
		this.result = result;
		this.occurrenceBean = occurrenceBean;
		this.validationBundle = validationBundle;
	}
	
	@Path( { "/" , "" } )
	public void list(){
		result.include("occurrences",  occurrenceBean.findAll() );
	}
	
	@Path("/{ocurrenceId}")
	public void detail( Long ocurrenceId ){
		Occurrence occurrence = occurrenceBean.findById(ocurrenceId);
		if(occurrence == null){
			String errorMessage = validationBundle.getString("occurrence.notFound");
			errorMessage = MessageFormat.format( errorMessage ,  ocurrenceId.toString() );
			result.include("errorMessage" , errorMessage );
		}
		result.include( "occurrence" , occurrence );
	}
	
	@Path("find")
	public void find( Long filter , Validator validator ){
		if( validator.hasErrors() ){
			validator.add( new SimpleMessage( "occurrences", validationBundle.getString("occurrence.wrongFilter") ) );
		}
		validator.onErrorUsePageOf( ListOccurrenceController.class ).list();
		
		result.forwardTo( ListOccurrenceController.class ).detail( filter  );
	}
	
}
