package de.frakit.birthcertificate.citizen;

import de.frakit.birthcertificate.citizen.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
