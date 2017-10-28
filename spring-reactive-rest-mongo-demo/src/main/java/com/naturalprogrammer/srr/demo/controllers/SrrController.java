package com.naturalprogrammer.srr.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.srr.commons.AbstractSrrController;
import com.naturalprogrammer.srr.demo.domain.UserEntity;

@RestController
@RequestMapping("/api/core")
public class SrrController extends AbstractSrrController<UserEntity, String> {

}
