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
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Occurrence implements Serializable {
	
	private static final long serialVersionUID = -9182122904967670112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfOpening;
	
	private String serialId;
	
	@NotEmpty
	@Lob
	private String description;

	@ManyToOne
	@JoinColumn(name="occurrenceState_id")
	private OccurrenceState occurrenceState;
	
	@ManyToOne
	@JoinColumn(name = "problemType_id" , nullable = false)
	private ProblemType problemType;
	
	@ManyToOne
	@JoinColumn(name = "sector_id" , nullable = false)
	private Sector sector;
	
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "occurrence" , fetch = FetchType.EAGER)
	private List<OccurrenceUpdate> updates;
	
	public Occurrence() { }
	
	@PrePersist
	public void runBeforeCreate(){
		dateOfOpening = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}



	public OccurrenceState getOccurrenceState() {
		return occurrenceState;
	}



	public void setOccurrenceState(OccurrenceState occurrenceState) {
		this.occurrenceState = occurrenceState;
	}

	public List<OccurrenceUpdate> getUpdates() {
		return updates;
	}

	public void setUpdates(List<OccurrenceUpdate> updates) {
		this.updates = updates;
	}
	
}