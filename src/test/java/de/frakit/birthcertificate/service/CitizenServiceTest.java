package de.frakit.birthcertificate.service;

import de.frakit.birthcertificate.model.*;
import de.frakit.birthcertificate.repository.CitizenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CitizenServiceTest {

    /**
     * Autowire in the service we want to test
     */
    @Autowired
    private CitizenService service;

    @MockBean
    private CitizenRepository citizenRepository;


    @Test
    @DisplayName("Test findAll mit Probe Success")
    void findAll() {
        // Creating an example
        Citizen probe = new Citizen();
        probe.setSex(Sex.MALE);
        Example<Citizen> example = Example.of(probe);

        Address address = new Address("Bahnhofstr", 17, "Frankfurt");
        Citizen citizen1 = new Citizen(null, "", "Fru", "Mann", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST.code(), "fru@gmail.com", "fru@gmail.com", "1234", "5678", null, 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, Sex.MALE, "", address, LocalDate.now(), LocalDate.now(), "", "", false, LocalDate.now());
        doReturn(List.of(citizen1)).when(citizenRepository).findAll(example);

        // Execute the service call
        List<Citizen> returnedCitizen = service.findAll(probe);

        Assertions.assertTrue(!returnedCitizen.isEmpty(), "Citizen was not found");
        Assertions.assertSame(returnedCitizen.get(0), citizen1, "The citizen returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
        Address address = new Address("Bahnhofstr", 17, "Frankfurt");
        Citizen citizen1 = new Citizen(null, "", "Fru", "Mann", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST.code(), "fru@gmail.com", "fru@gmail.com", "1234", "5678", null, 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, Sex.MALE, "", address, LocalDate.now(), LocalDate.now(), "", "", false, LocalDate.now());
        Citizen citizen2 = new Citizen(null, "", "Lucy", "MISTER", LocalDate.of(1982, Month.APRIL, 17), "Bonaberi", Region.LITTORAL.code(), "lucy@gmail.com", "lucy2@gmail.com", "1234", "5678", null, 10003333000L, 22233337L, 13L, MarriageStatus.MARRIED, Sex.FEMALE, "", address, LocalDate.now(), LocalDate.now(), "", "", false, LocalDate.now());
        doReturn(Arrays.asList(citizen1, citizen2)).when(citizenRepository).findAll();

        // Execute the service call
        List<Citizen> citizens = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, citizens.size(), "findAll should return 2 widgets");
    }
}