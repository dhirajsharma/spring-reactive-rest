package com.naturalprogrammer.srr.demo.repositories;

import com.naturalprogrammer.srr.demo.domain.UserEntity;
import com.naturalprogrammer.srr.mongo.AbstractUserRepository;

public interface UserRepository extends AbstractUserRepository<UserEntity, String> {

}
