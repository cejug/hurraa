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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date dateOfOppening;
	
	private String serialId;
	
	@NotEmpty
	private String description;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "problemType_id" , nullable = false)
	private ProblemType problemType;
	
	@ManyToOne
	@JoinColumn(name = "sector_id" , nullable = false)
	private Sector sector;
	
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user;
	
	public Occurrence() { }
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfOppening() {
		return dateOfOppening;
	}

	public void setDateOfOppening(Date dateOfOppening) {
		this.dateOfOppening = dateOfOppening;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
}