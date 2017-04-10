package de.alt.senseless.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.alt.senseless.model.entities.Account;
import de.alt.senseless.model.repos.AccountRepository;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner createRegi(AccountRepository accountRepository) {
		return args -> {

			accountRepository.save(new Account("regi", "password"));

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
