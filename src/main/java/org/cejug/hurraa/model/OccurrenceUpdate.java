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
package org.cejug.hurraa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Timeout;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.cejug.hurraa.model.builder.OccurrenceFieldUpdateBuilder;

@Entity
public class OccurrenceUpdate implements Serializable {
	
	private static final long serialVersionUID = -2861856691981925823L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String updateNote;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@ManyToOne
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="occurrence_id", nullable = false)
	private Occurrence occurrence;
	
	@OneToMany(mappedBy="occurrenceUpdate" , orphanRemoval=true , cascade = CascadeType.ALL  , fetch = FetchType.EAGER)
	private List<OccurrenceFieldUpdate> updatedFields;
	
	@PrePersist
	public void prePersistRoutine(){
		updateDate = new Date();
	}
	
	public boolean occurrenceWasChanged(){
		return ( updateNote != null && !updateNote.isEmpty() )
				|| ( updatedFields != null && !updatedFields.isEmpty() );
	}
	
	public OccurrenceUpdate() {	}
	
	public OccurrenceUpdate( Occurrence occurrence , String updateNote ) {
		this.occurrence = occurrence;
		this.updateNote = updateNote;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUpdateNote() {
		return updateNote;
	}

	public void setUpdateNote(String updateNote) {
		this.updateNote = updateNote;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OccurrenceFieldUpdate> getUpdatedFields() {
		return updatedFields;
	}

	public void setUpdatedFields(List<OccurrenceFieldUpdate> updatedFields) {
		this.updatedFields = updatedFields;
	}

	public Occurrence getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(Occurrence occurrence) {
		this.occurrence = occurrence;
	}

}
