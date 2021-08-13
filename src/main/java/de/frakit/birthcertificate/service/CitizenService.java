package de.frakit.birthcertificate.service;

import de.frakit.birthcertificate.model.Citizen;
import de.frakit.birthcertificate.repository.CitizenRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

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

    public List<Citizen> findAllByFirstOrLastName(Citizen exampleCitizen) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("firstName", contains().ignoreCase())
                .withMatcher("lastName", contains().ignoreCase());
        return citizenRepository.findAll(Example.of(exampleCitizen, matcher));
    }

    public List<Citizen> findAllByFirstOrLastName(String name) {
        return citizenRepository.findAllByFirstOrLastName(name);
    }

    public Optional<Citizen> findById(Long id) {
        return citizenRepository.findById(id);
    }
}
