package com.naturalprogrammer.srr.mongo;

import java.io.Serializable;

import com.naturalprogrammer.srr.commons.AbstractSrrService;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;

import reactor.core.publisher.Mono;

public abstract class AbstractSrrMongoService
	<U extends AbstractUser<ID>, ID extends Serializable>
	extends AbstractSrrService<U, ID> {
	
}
