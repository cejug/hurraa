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

import org.cejug.hurraa.model.OccurrenceFieldUpdate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OccurrenceFieldUpdateBuilderTest {
	
	private OccurrenceFieldUpdateBuilder builder;
	
	@Before
	public void setUp(){
		builder = new OccurrenceFieldUpdateBuilder();
	}
	
	
	@Test
	public void doesCreateOccurrenceFieldUpdateWithTheEspecifiedFields(){
		String fieldName = "My Field Name";
		String newValue = "New Value";
		String oldValue = "Old Value";
		
		OccurrenceFieldUpdate ofu = builder.withFieldName(fieldName).withNewValue(newValue).withOldValue(oldValue).build();
		
		assertEquals( fieldName , ofu.getFieldName() );
		assertEquals( newValue , ofu.getNewValue() );
		assertEquals( oldValue , ofu.getOldValue() );
	}
	
	@Test
	public void doesResetTheBuilderAfterABuild(){
		String fieldName = "My Field Name";
		String newValue = "New Value";
		String oldValue = "Old Value";
		
		OccurrenceFieldUpdate firstBuild  = builder.withFieldName(fieldName).withNewValue(newValue).withOldValue(oldValue).build();
		//Build again to reset
		OccurrenceFieldUpdate secondBuild = builder.build();
		
		assertFalse("The fieldName should not be equals" , firstBuild.getFieldName().equals( secondBuild.getFieldName() ) );
		assertFalse("The newValue should not be equals" , firstBuild.getNewValue().equals( secondBuild.getNewValue() ) );
		assertFalse("The oldValue should not be equals" , firstBuild.getOldValue().equals( secondBuild.getOldValue() ) );
	}
	
}
