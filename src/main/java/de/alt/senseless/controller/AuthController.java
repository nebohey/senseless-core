package de.alt.senseless.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.alt.senseless.model.Account;
import de.alt.senseless.model.AccountRepository;
import de.alt.senseless.model.AuthToken;
import de.alt.senseless.model.AuthTokenRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AccountRepository accountRepository;

	private final AuthTokenRepository authTokenRepository;

	@Autowired
	AuthController(AccountRepository accountRepository, AuthTokenRepository authTokenRepository) {
		this.authTokenRepository = authTokenRepository;
		this.accountRepository = accountRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	public AuthToken authenticate(@RequestParam String username, @RequestParam String password) {

		Account account = accountRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));

		AuthToken authToken = null;
		if (account.getPassword().equals(password)) {
			authToken = createAuthToken(account);
		}

		return authToken;
	}

	@RequestMapping(path = "/{token}", method = RequestMethod.GET)
	boolean checkToken(@PathVariable String token) {

		AuthToken authToken = authTokenRepository.findByToken(token);

		if (authToken != null && authToken.getValidUntil().after(new Date())) {
			return true;
		} else {
			return false;
		}
	}

	private AuthToken createAuthToken(Account account) {

		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);

		return authTokenRepository.save(new AuthToken(account, token));
	}

}
