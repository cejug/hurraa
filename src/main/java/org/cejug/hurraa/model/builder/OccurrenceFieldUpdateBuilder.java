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
package org.cejug.hurraa.model.builder;

import org.cejug.hurraa.model.Occurrence;
import org.cejug.hurraa.model.OccurrenceFieldUpdate;
import org.cejug.hurraa.model.OccurrenceUpdate;

public class OccurrenceFieldUpdateBuilder {
	
	private OccurrenceFieldUpdate occurrenceFieldUpdate;
	
	public OccurrenceFieldUpdateBuilder() {
		occurrenceFieldUpdate = new OccurrenceFieldUpdate();
	}
	
	public OccurrenceFieldUpdateBuilder forOccurrenceUpdate(OccurrenceUpdate occurrenceUpdate){
		occurrenceFieldUpdate.setOccurrenceUpdate( occurrenceUpdate );
		return this;
	}
	
	public OccurrenceFieldUpdateBuilder withFieldName(String fieldName){
		occurrenceFieldUpdate.setFieldName(fieldName);
		return this;
	}
	
	public OccurrenceFieldUpdateBuilder withNewValue(String newValue){
		occurrenceFieldUpdate.setNewValue(newValue);
		return this;
	}
	
	public OccurrenceFieldUpdateBuilder withOldValue(String oldValue){
		occurrenceFieldUpdate.setOldValue(oldValue);
		return this;
	}
	
	public OccurrenceFieldUpdate build(){
		try{
			return occurrenceFieldUpdate;
		}finally{
			occurrenceFieldUpdate = new OccurrenceFieldUpdate();
		}
	}
	
}
