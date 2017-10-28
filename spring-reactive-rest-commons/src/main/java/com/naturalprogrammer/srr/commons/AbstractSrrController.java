package com.naturalprogrammer.srr.commons;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;
import com.naturalprogrammer.srr.commons.domain.AbstractUser.SignupInput;

import reactor.core.publisher.Mono;

public abstract class AbstractSrrController<U extends AbstractUser<ID>, ID extends Serializable> {
	
	private static final Log log = LogFactory.getLog(AbstractSrrController.class);

	private AbstractSrrService<U, ID> srrService;
	
	@Autowired
	public void setSrrService(AbstractSrrService<U, ID> srrService) {
		this.srrService = srrService;
		log.info("Created");
	}

	/**
	 * Signs up a user, and logs him in.
     *
	 * @param user	data fed by the user
	 * @return data about the logged in user
	 */
	@PostMapping(value = "/users"/*, produces = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<U> signup(@RequestBody @JsonView(SignupInput.class) Mono<U> user) {
		
		log.debug("Signing up: " + user);
		Mono<U> u = srrService.signup(user);
		log.debug("Signed up: " + user);
		
		return u;
	}
}
