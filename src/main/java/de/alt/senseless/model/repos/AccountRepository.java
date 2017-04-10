package de.alt.senseless.model.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.alt.senseless.model.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
