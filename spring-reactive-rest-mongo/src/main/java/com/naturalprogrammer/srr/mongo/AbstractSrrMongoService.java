package com.naturalprogrammer.srr.mongo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.naturalprogrammer.srr.commons.AbstractSrrService;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractSrrMongoService
	<U extends AbstractUser<ID>, ID extends Serializable>
	extends AbstractSrrService<U, ID> {

	@Autowired
	private AbstractUserRepository<U, ID> userRepository;

	@Override
	protected Mono<U> insert(Mono<U> user) {
		Flux<U> savedUser = userRepository.insert(user);
		return savedUser.next();
	}
}
