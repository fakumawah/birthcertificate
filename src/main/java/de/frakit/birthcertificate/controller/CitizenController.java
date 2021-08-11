package de.frakit.birthcertificate.controller;

import de.frakit.birthcertificate.model.Citizen;
import de.frakit.birthcertificate.model.Sex;
import de.frakit.birthcertificate.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/citizen")
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Citizen> findAll() {
        return citizenService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/males")
    public List<Citizen> findAllMale() {
        Citizen probe = new Citizen();
        probe.setSex(Sex.MALE);
        probe.setFirstName("Fr");
        return citizenService.findAll(probe);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/females")
    public List<Citizen> findAllFemale() {
        Citizen probe = new Citizen();
        probe.setSex(Sex.FEMALE);
        return citizenService.findAll(probe);
    }

    @DeleteMapping
    public void deleteCitizen(Long citizenId) {
        citizenService.deleteCitizen(citizenId);
    }
}
