package com.naturalprogrammer.srr.commons.domain;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.naturalprogrammer.srr.commons.AbstractSrrService;
import com.naturalprogrammer.srr.commons.utils.SrUtils;

public abstract class AbstractUser<ID extends Serializable> extends AbstractEntity<ID> {
	
	private String email;
	private String password;
	
	private static final long serialVersionUID = -8289175350021428063L;
	
	// validation groups
	public interface SignUpValidation {}
	public interface UpdateValidation {}
	public interface ChangeEmailValidation {}
	
	// JsonView for Sign up
	public interface SignupInput {}
		
	public static class Deserializer extends StdDeserializer<AbstractUser<?>> { 
		 
		public Deserializer() {
			super(AbstractUser.class);
		}

		private static final long serialVersionUID = 5232308881165381696L;

	    @Override
	    public AbstractUser<?> deserialize(JsonParser jp, DeserializationContext ctxt) 
	      throws IOException, JsonProcessingException {
	    	
	    	AbstractSrrService<?, ?> srrService = SrUtils.getBean(AbstractSrrService.class);
	    			
	        JsonNode node = jp.getCodec().readTree(jp);
	    	return srrService.getUserEntity(node);
	    }
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
