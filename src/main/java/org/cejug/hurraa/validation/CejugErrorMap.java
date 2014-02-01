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
