package com.naturalprogrammer.srr.mongo.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.naturalprogrammer.srr.commons.domain.AbstractUser;

@Document
public abstract class MongoUser<ID extends Serializable> extends AbstractUser<ID> {

	private static final long serialVersionUID = -3043979697399444328L;
}
