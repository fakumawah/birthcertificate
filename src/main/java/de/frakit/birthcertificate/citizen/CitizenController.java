package de.frakit.birthcertificate.citizen;

import de.frakit.birthcertificate.citizen.model.Citizen;
import de.frakit.birthcertificate.citizen.model.Sex;
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
        return citizenService.findAll(probe);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/females")
    public List<Citizen> findAllFemale() {
        Citizen probe = new Citizen();
        probe.setSex(Sex.FEMALE);
        return citizenService.findAll(probe);
    }

    @GetMapping("/{id}")
    Citizen one(@PathVariable Long id) {
        return citizenService.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/any/{name}")
    public List<Citizen> findAllByFirstOrLastName(@PathVariable String name) {
        Citizen probe = new Citizen();
        probe.setFirstName(name);
        return citizenService.findAllByFirstOrLastName(probe);
    }

    @GetMapping("/spec/{name}")
    public List<Citizen> findCustomersByFirstName(@PathVariable String name) {
        return citizenService.findAllByFirstOrLastName(name);
    }

    @DeleteMapping
    public void deleteCitizen(Long citizenId) {
        citizenService.deleteCitizen(citizenId);
    }

}
