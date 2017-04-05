package de.alt.senseless.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithoutAnySense {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!!!";
	}

	@RequestMapping("/auth")
	public String auth() {

		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);

		return token;
	}

}
