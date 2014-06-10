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
package org.cejug.hurraa.model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.cejug.hurraa.model.Occurrence;
import org.cejug.hurraa.model.OccurrenceFieldUpdate;
import org.cejug.hurraa.model.OccurrenceState;
import org.cejug.hurraa.model.OccurrenceUpdate;
import org.cejug.hurraa.model.ProblemType;
import org.cejug.hurraa.model.Sector;
import org.cejug.hurraa.model.User;
import org.cejug.hurraa.model.bean.exception.NoChangeInOccurrenceException;
import org.cejug.hurraa.model.builder.OccurrenceFieldUpdateBuilder;

import com.opensymphony.sitemesh.compatability.OldDecorator2NewDecorator;

@Stateless
public class OccurrenceBean extends AbstractBean<Occurrence> {
	
	public OccurrenceBean() {
		super(Occurrence.class);
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Occurrence entity) {
		super.insert(entity);
	}
	
	public void updateOccurrence(Occurrence occurrence , String updateNote, User user) throws NoChangeInOccurrenceException{
		Occurrence oldOccurrence = findById( occurrence.getId() );
		OccurrenceUpdate occurrenceUpdate = new OccurrenceUpdate( occurrence , updateNote);
		occurrenceUpdate.setUser(user);
		occurrenceUpdate = checkDiffInTheFields( occurrenceUpdate , oldOccurrence );
		
		if( occurrenceUpdate.occurrenceWasChanged() ){
			updateNewValues( occurrence , oldOccurrence );
			entityManager.persist(occurrenceUpdate);
		}else{
			throw new NoChangeInOccurrenceException();
		}
	}
	
	public OccurrenceUpdate checkDiffInTheFields(OccurrenceUpdate occurrenceUpdate, Occurrence oldOccurrence) {
		List<OccurrenceFieldUpdate>  updatedFields = new ArrayList<>();
		Occurrence occurrence = occurrenceUpdate.getOccurrence();
		OccurrenceFieldUpdateBuilder builder = new OccurrenceFieldUpdateBuilder();
		
		OccurrenceFieldUpdate fieldUpdate;
		if(!oldOccurrence.getSector().equals(occurrence.getSector())){
			String newValue = entityManager.find( Sector.class , occurrence.getSector().getId() ).getName();
			fieldUpdate = builder.withFieldName("sector").withNewValue( newValue )
					.withOldValue( oldOccurrence.getSector().getName() ).forOccurrenceUpdate(occurrenceUpdate).build();
			updatedFields.add(fieldUpdate);
		}
		if(!oldOccurrence.getProblemType().equals(occurrence.getProblemType() )){
			String newValue = entityManager.find( ProblemType.class , occurrence.getProblemType().getId() ).getName();
			fieldUpdate = builder.withFieldName("problemType").withNewValue( newValue )
					.withOldValue( oldOccurrence.getProblemType().getName() ).forOccurrenceUpdate(occurrenceUpdate).build();
			updatedFields.add(fieldUpdate);
		}
		if(!oldOccurrence.getOccurrenceState().equals( occurrence.getOccurrenceState() )){
			String newValue = entityManager.find( OccurrenceState.class , occurrence.getOccurrenceState().getId() ).getName();
			fieldUpdate = builder.withFieldName("occurrenceState").withNewValue( newValue )
					.withOldValue( oldOccurrence.getOccurrenceState().getName() ).forOccurrenceUpdate(occurrenceUpdate).build();
			updatedFields.add(fieldUpdate);
		}
		
		occurrenceUpdate.setUpdatedFields(updatedFields);
		return occurrenceUpdate;
	}
	
	private void updateNewValues(Occurrence occurrence , Occurrence oldOccurrence){
		oldOccurrence.setSector( occurrence.getSector()  );
		oldOccurrence.setOccurrenceState( occurrence.getOccurrenceState() );
		oldOccurrence.setProblemType( occurrence.getProblemType() );
		update( oldOccurrence );
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
