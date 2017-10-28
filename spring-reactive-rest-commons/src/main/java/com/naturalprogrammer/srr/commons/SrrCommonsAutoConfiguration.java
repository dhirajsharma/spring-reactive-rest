package com.naturalprogrammer.srr.commons;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.naturalprogrammer.srr.commons.domain.AbstractUser;

@Configuration
@AutoConfigureBefore({
	WebFluxAutoConfiguration.class,
	ErrorMvcAutoConfiguration.class})
public class SrrCommonsAutoConfiguration {
	
	@Bean
	public SimpleModule simpleModule() {
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(AbstractUser.class, new AbstractUser.Deserializer());
		
		return module;
	}
}
