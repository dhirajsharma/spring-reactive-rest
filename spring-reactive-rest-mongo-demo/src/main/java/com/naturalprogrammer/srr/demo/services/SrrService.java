package com.naturalprogrammer.srr.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturalprogrammer.srr.demo.domain.UserEntity;
import com.naturalprogrammer.srr.demo.repositories.UserRepository;
import com.naturalprogrammer.srr.mongo.AbstractSrrMongoService;
import com.naturalprogrammer.srr.mongo.AbstractUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SrrService extends AbstractSrrMongoService<UserEntity, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected Mono<UserEntity> save(Mono<UserEntity> user) {
		Flux<UserEntity> savedUser = userRepository.insert(user);
		return savedUser.next();
	}
}
