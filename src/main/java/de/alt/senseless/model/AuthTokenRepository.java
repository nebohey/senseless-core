package de.alt.senseless.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
	AuthToken findByToken(String token);
}
