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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class OccurrenceFieldUpdate implements Serializable {
	
	private static final long serialVersionUID = 5317998715760939361L;

	@Id
	@Column(name="occurrenceUpdate_id" )
	private Long ocurrenceUpdateId;
	
	@ManyToOne
	@JoinColumn( name="occurrenceUpdate_id" , insertable = false , updatable = false )
	private OccurrenceUpdate occurrenceUpdate;
	
	@NotBlank
	private String fieldName;
	
	@NotNull
	private String oldValue;
	
	@NotNull
	private String newValue;
	
	@PrePersist
	public void prePersisteRoutine(){
		ocurrenceUpdateId = occurrenceUpdate.getId();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OccurrenceFieldUpdate [ocurrenceUpdateId=");
		builder.append(ocurrenceUpdateId);
		builder.append(", occurrenceUpdate=");
		builder.append(occurrenceUpdate);
		builder.append(", fieldName=");
		builder.append(fieldName);
		builder.append(", oldValue=");
		builder.append(oldValue);
		builder.append(", newValue=");
		builder.append(newValue);
		builder.append("]");
		return builder.toString();
	}

	public OccurrenceUpdate getOccurrenceUpdate() {
		return occurrenceUpdate;
	}

	public void setOccurrenceUpdate(OccurrenceUpdate occurrenceUpdate) {
		this.occurrenceUpdate = occurrenceUpdate;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Long getOcurrenceUpdateId() {
		return ocurrenceUpdateId;
	}

	public void setOcurrenceUpdateId(Long ocurrenceUpdateId) {
		this.ocurrenceUpdateId = ocurrenceUpdateId;
	}
	
}
