package de.alt.senseless.model.repos;

import de.alt.senseless.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByName(String name);
}

