package de.alt.senseless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.alt.senseless.exception.UserNotFoundException;
import de.alt.senseless.model.entities.Account;
import de.alt.senseless.model.repos.AccountRepository;

@RestController
@RequestMapping("/account/{username}")
public class AccountController {

	private final AccountRepository accountRepository;

	@Autowired
	AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Account readAddress(@PathVariable String username) {
		return this.accountRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
	}

}
