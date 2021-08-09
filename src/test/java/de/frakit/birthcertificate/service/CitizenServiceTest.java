package de.frakit.birthcertificate.service;

import de.frakit.birthcertificate.model.Citizen;
import de.frakit.birthcertificate.model.MarriageStatus;
import de.frakit.birthcertificate.model.Region;
import de.frakit.birthcertificate.model.Sex;
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

        Citizen citizen1 = new Citizen("", "Fru", "Anye", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST, Sex.MALE, "fru@gmail.com", "fru@gmail.com", "1234", "5678", 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, "", LocalDate.now(), LocalDate.now(), null);
        Citizen citizen2 = new Citizen("", "Lucy", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Mankon",Region.NORTHWEST, Sex.FEMALE, "lucy@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
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
        Citizen citizen1 = new Citizen("", "Fru", "Anye", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST, Sex.MALE, "fru@gmail.com", "fru@gmail.com", "1234", "5678", 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, "", LocalDate.now(), LocalDate.now(), null);
        Citizen citizen2 = new Citizen("", "Lucy", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Mankon",Region.NORTHWEST, Sex.FEMALE, "lucy@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
        doReturn(Arrays.asList(citizen1, citizen2)).when(citizenRepository).findAll();

        // Execute the service call
        List<Citizen> citizens = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, citizens.size(), "findAll should return 2 widgets");
    }
}