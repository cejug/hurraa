/*
* This file is part of Hurraa.
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
package org.cejug.hurraa.validation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.validator.Message;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Multimap;

public class CejugErrorMap extends ForwardingMap<String, Collection<String>>{
	
	private final Map<String, Collection<String>> delegate;
	private List<Message> messages;

	public CejugErrorMap(List<Message> messages) {
		Multimap<String, String> out = ArrayListMultimap.create();
		for (Message message : messages) {
			out.put(message.getCategory(), message.getMessage());
		}
		this.delegate = out.asMap();
		this.messages = messages;
		
	}
	
	public List<Message> asList() {
		return messages;
	}
	
	
	@Override
	protected Map<String, Collection<String> > delegate() {
		return delegate;
	}
	

}
