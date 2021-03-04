package com.lab.redis.web.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index() {
		return "Laboratório de REDIS no ar!\n!";
	}

}
