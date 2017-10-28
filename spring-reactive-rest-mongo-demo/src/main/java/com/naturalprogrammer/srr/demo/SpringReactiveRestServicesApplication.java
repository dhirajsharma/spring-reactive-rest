package com.naturalprogrammer.srr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naturalprogrammer.srr.commons.SrrCommonsAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {
		SpringReactiveRestServicesApplication.class,
		SrrCommonsAutoConfiguration.class})
public class SpringReactiveRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveRestServicesApplication.class, args);
	}
}
