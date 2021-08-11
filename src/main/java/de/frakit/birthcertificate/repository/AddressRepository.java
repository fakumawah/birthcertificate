package de.frakit.birthcertificate.repository;

import de.frakit.birthcertificate.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
