package com.naturalprogrammer.srr.commons;

import java.io.Serializable;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.JsonNode;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;
import com.naturalprogrammer.srr.commons.domain.AbstractUser.SignUpValidation;

import reactor.core.publisher.Mono;

@Validated
public abstract class AbstractSrrService<U extends AbstractUser<ID>, ID extends Serializable> {

	private static final Log log = LogFactory.getLog(AbstractSrrService.class);
	
	@Validated(SignUpValidation.class)
	public Mono<U> signup(@Valid Mono<U> user) {
	
		log.debug("Signing up user: " + user);

		user.map(this::initUser);
		
		return insert(user);
		
//		// if successfully committed
//		LemonUtils.afterCommit(() -> {
//		
//			LemonUtils.logIn(user); // log the user in
//			sendVerificationMail(user); // send verification mail
//			log.debug("Signed up user: " + user);
//		});
	}

	protected abstract U newUserEntity();
	protected abstract Mono<U> insert(Mono<U> user);
	
	public U getUserEntity(JsonNode node) {
		
        String email = node.get("email").asText();
        String password = node.get("password").asText();
 
        U user = newUserEntity();
        
        user.setEmail(email);
        user.setPassword(password);
        
        return user;
	}

	/**
	 * Initializes the user based on the input data
	 * 
	 * @param user
	 */
	protected U initUser(U user) {
		
		log.debug("Initializing user: " + user);

		user.setPassword(/*passwordEncoder.encode(*/user.getPassword()); // encode the password
		makeUnverified(user); // make the user unverified
		return user;
	}

	private void makeUnverified(U user) {
		// TODO Auto-generated method stub
		
	}

}
