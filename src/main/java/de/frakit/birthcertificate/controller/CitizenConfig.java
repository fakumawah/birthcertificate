package de.frakit.birthcertificate.controller;

import de.frakit.birthcertificate.model.*;
import de.frakit.birthcertificate.repository.AddressRepository;
import de.frakit.birthcertificate.repository.CitizenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CitizenConfig {

    @Bean
    CommandLineRunner commandLineRunner(CitizenRepository citizenRepository, AddressRepository addressRepository) {
        return args -> {
            Address address = new Address("Bahnhofstr", 17, "Frankfurt");
            Address address2 = new Address("Poststr", 334, "Leipzig");
            Address address3 = new Address("Langener", 33, "Berlin");
            Citizen citizen1 = new Citizen(null, "", "Fru", "Mann", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST.code(), "fru@gmail.com", "fru@gmail.com", "1234", "5678", null, 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, Sex.MALE, "", address, null, null, "", "", false, LocalDate.now());
            Citizen citizen2 = new Citizen(null, "", "Lucy", "MISTER", LocalDate.of(1982, Month.APRIL, 17), "Bonaberi", Region.LITTORAL.code(), "lucy@gmail.com", "lucy2@gmail.com", "1234", "5678", null, 10003333000L, 22233337L, 13L, MarriageStatus.MARRIED, Sex.FEMALE, "", address2, null, null, "", "", false, LocalDate.now());
            Citizen citizen3 = new Citizen(null, "", "Anna", "Anatol", LocalDate.of(1985, Month.SEPTEMBER, 23), "Nchang", Region.OUEST.code(), "anna@gmail.com", "anna2@gmail.com", "1234", "5678", null, 10004440L, 222444447L, 12L, MarriageStatus.SINGLE, Sex.FEMALE, "", address3, null, null, "", "", false, LocalDate.now());
            Citizen citizen4 = new Citizen(null, "", "Steve", "Frgej", LocalDate.of(1987, Month.DECEMBER, 19), "Kouseri", Region.EXTREMENORD.code(), "steve@gmail.com", "steve2@gmail.com", "1234", "5678", null, 100055500L, 222555557L, 12L, MarriageStatus.MARRIED, Sex.MALE, "", address2, null, null, "", "", false, LocalDate.now());
            Citizen citizen5 = new Citizen(null, "", "Patrick", "Pancreta", LocalDate.of(1983, Month.JANUARY, 12), "Essos", Region.CENTRE.code(), "patrick@gmail.com", "patrick2@gmail.com", "1234", "5678", null, 10666600L, 222266666L, 13L, MarriageStatus.SINGLE, Sex.MALE, "", address3, null, null, "", "", false, LocalDate.now());
            Citizen citizen6 = new Citizen(null, "", "Alisia", "Lionji", LocalDate.of(1981, Month.JULY, 03), "Bertoua", Region.EST.code(), "alisia@gmail.com", "alisia2@gmail.com", "1234", "5678", null, 10077700L, 222777777L, 12L, MarriageStatus.MARRIED, Sex.FEMALE, "", address, null, null, "", "", false, LocalDate.now());
            Citizen citizen7 = new Citizen(null, "", "George", "Anje", LocalDate.of(1984, Month.JUNE, 10), "Ebolowa", Region.SUD.code(), "george@gmail.com", "george2@gmail.com", "1234", "5678", null, 10088800L, 222288888L, 13L, MarriageStatus.DIVORCED, Sex.MALE, "", address3, null, null, "", "", false, LocalDate.now());
            Citizen citizen8 = new Citizen(null, "", "Maria", "Para", LocalDate.of(1980, Month.FEBRUARY, 11), "Ndop", Region.NORTHWEST.code(), "maria@gmail.com", "maria2@gmail.com", "1234", "5678", null, 10099900L, 222999999L, 14L, MarriageStatus.SINGLE, Sex.FEMALE, "", address2, null, null, "", "", false, LocalDate.now());
            citizenRepository.saveAll(List.of(citizen1, citizen2, citizen3, citizen4, citizen5, citizen6, citizen7, citizen8));
        };
    }
}
