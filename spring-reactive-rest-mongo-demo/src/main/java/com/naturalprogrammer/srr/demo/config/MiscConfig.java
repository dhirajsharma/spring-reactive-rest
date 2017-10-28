package com.naturalprogrammer.srr.demo.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;
import com.naturalprogrammer.srr.demo.domain.UserEntity;

@Configuration
public class MiscConfig {
	
//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//		
//		return (jacksonObjectMapperBuilder) -> {
//			
//			jacksonObjectMapperBuilder.mixIn(AbstractUser.class, UserEntity.UserMixIn.class);
//		};
//	}
	
	@Bean
	public SimpleModule simpleModule() {
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(AbstractUser.class, new UserEntity.Deserializer());
		
		return module;
	}

}
