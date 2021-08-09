package de.frakit.birthcertificate.service;

import de.frakit.birthcertificate.model.Citizen;
import de.frakit.birthcertificate.repository.CitizenRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    public void deleteCitizen(Long citizenId) {
        Citizen citizen = null;
        if (citizenRepository.existsById(citizenId)) {
            citizen = citizenRepository.getById(citizenId);
        }
        if (Boolean.FALSE.equals(citizen.getDeleted())) {
            citizen.setDeleted(Boolean.TRUE);
            citizen.setDeletedOn(LocalDate.now());
            citizenRepository.save(citizen);
        }
    }

    public void delete(Long citizenId) {
        citizenRepository.deleteById(citizenId);
    }

    public List<Citizen> findAll(Citizen exampleCitizen) {
        return citizenRepository.findAll(Example.of(exampleCitizen));
    }
}
