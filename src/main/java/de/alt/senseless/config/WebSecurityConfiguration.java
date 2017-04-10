package de.alt.senseless.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import de.alt.senseless.exception.UserNotFoundException;
import de.alt.senseless.model.entities.Account;
import de.alt.senseless.model.repos.AccountRepository;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				Account account = accountRepository.findByUsername(username)
						.orElseThrow(() -> new UserNotFoundException(username));

				return new User(account.getUsername(), account.getPassword(), true, true, true, true,
						AuthorityUtils.createAuthorityList("USER"));
			}

		};
	}
}