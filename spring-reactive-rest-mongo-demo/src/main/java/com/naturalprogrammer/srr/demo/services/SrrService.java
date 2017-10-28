package com.naturalprogrammer.srr.demo.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.naturalprogrammer.srr.demo.domain.UserEntity;
import com.naturalprogrammer.srr.mongo.AbstractSrrMongoService;

@Service
public class SrrService extends AbstractSrrMongoService<UserEntity, String> {

	@Override
	protected UserEntity newUserEntity() {
		return new UserEntity();
	}
	
	@Override
	public UserEntity getUserEntity(JsonNode node) {
		
		UserEntity user = super.getUserEntity(node);
		
        String name = node.get("name").asText();
        user.setName(name);
        
        return user;
	}
}
