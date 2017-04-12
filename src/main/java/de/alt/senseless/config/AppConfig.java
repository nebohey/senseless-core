package de.alt.senseless.config;

import java.util.Arrays;

import de.alt.senseless.model.entities.Address;
import de.alt.senseless.model.repos.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.alt.senseless.model.entities.Account;
import de.alt.senseless.model.entities.Bookmark;
import de.alt.senseless.model.repos.AccountRepository;
import de.alt.senseless.model.repos.BookmarkRepository;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner createRegi(AccountRepository accountRepository, BookmarkRepository bookmarkRepository, AddressRepository addressRepository) {

		return args -> {

			Account account = accountRepository.save(new Account("regi", "password"));

			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/foo", "A description"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/bar", "A description"));

			Address address = new Address("test", "127.0.0.1");
			addressRepository.save(address);

		};

	}

	@Bean
	public CommandLineRunner listSpringBootBeans(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();

			Arrays.sort(beanNames);

			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
