package com.naturalprogrammer.srr.demo.domain;

import com.naturalprogrammer.srr.mongo.entities.MongoUser;

public class UserEntity extends MongoUser<String> {

	private static final long serialVersionUID = -5081285535498118823L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
