package com.naturalprogrammer.srr.demo.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.jayway.jsonpath.internal.filter.ValueNode.StringNode;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;
import com.naturalprogrammer.srr.mongo.entities.MongoUser;

public class UserEntity extends MongoUser<String> {

	private static final long serialVersionUID = -5081285535498118823L;
	
//	// https://github.com/FasterXML/jackson-docs/wiki/JacksonMixInAnnotations
//	@JsonDeserialize(as = UserEntity.class)
//	public static abstract class UserMixIn {}
	
	
	public static class Deserializer extends StdDeserializer<AbstractUser<String>> { 
		 
		public Deserializer() {
			super(UserEntity.class);
		}

		private static final long serialVersionUID = 5232308881165381696L;

	    @Override
	    public AbstractUser<String> deserialize(JsonParser jp, DeserializationContext ctxt) 
	      throws IOException, JsonProcessingException {
	    	
	        JsonNode node = jp.getCodec().readTree(jp);
	        
	        String email = node.get("email").asText();
	        String password = node.get("password").asText();
	        String name = node.get("name").asText();
	 
	        UserEntity user = new UserEntity();
	        
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setName(name);
	        
	        return user;
	    }
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
