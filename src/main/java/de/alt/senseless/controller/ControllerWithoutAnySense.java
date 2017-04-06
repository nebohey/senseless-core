package de.alt.senseless.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithoutAnySense {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
