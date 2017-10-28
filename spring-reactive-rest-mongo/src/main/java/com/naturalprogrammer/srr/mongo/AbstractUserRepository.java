package com.naturalprogrammer.srr.mongo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.naturalprogrammer.srr.commons.domain.AbstractUser;

@NoRepositoryBean
public interface AbstractUserRepository
	<U extends AbstractUser<ID>, ID extends Serializable>
	extends ReactiveMongoRepository<U, ID> {

}
