package de.frakit.birthcertificate.repository;

import de.frakit.birthcertificate.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    @Query("select c from Citizen c where c.firstName like %?1% or c.lastName like %?1%")
    List<Citizen> findAllByFirstOrLastName(String name);
}
