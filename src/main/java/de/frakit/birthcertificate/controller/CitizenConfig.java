package de.frakit.birthcertificate.controller;

import de.frakit.birthcertificate.model.Citizen;
import de.frakit.birthcertificate.model.MarriageStatus;
import de.frakit.birthcertificate.model.Region;
import de.frakit.birthcertificate.model.Sex;
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
    CommandLineRunner commandLineRunner(CitizenRepository citizenRepository) {
        return args -> {
            Citizen citizen1 = new Citizen("", "Fru", "Anye", LocalDate.of(1981, Month.AUGUST, 06), "Bamenda", Region.NORTHWEST, Sex.MALE,"fru@gmail.com", "fru@gmail.com", "1234", "5678", 10002000L, 22224567L, 12L, MarriageStatus.SINGLE, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen2 = new Citizen("", "Lucy", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Mankon",Region.NORTHWEST, Sex.FEMALE, "lucy@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen3 = new Citizen("", "Anna", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Bonaberi",Region.LITTORAL,Sex.FEMALE, "anna@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen4 = new Citizen("", "Steve", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Nchang",Region.OUEST,Sex.MALE, "steve@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen5 = new Citizen("", "Patrick", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Kouseri",Region.EXTREMENORD,Sex.MALE, "patrick@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen6 = new Citizen("", "Alisia", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Essos",Region.CENTRE,Sex.FEMALE, "alishia@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen7 = new Citizen("", "George", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Bertoua",Region.EST,Sex.MALE, "george@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            Citizen citizen8 = new Citizen("", "Maria", "Mann", LocalDate.of(1984, Month.APRIL, 06), "Ebolowa",Region.SUD,Sex.FEMALE, "maria@gmail.com", "anye2@gmail.com", "987632323", "0789454", 33332000L, 78784567L, 13L, MarriageStatus.MARRIED, "", LocalDate.now(), LocalDate.now(), null );
            citizenRepository.saveAll(List.of(citizen1, citizen2, citizen3, citizen4, citizen5, citizen6, citizen7, citizen8));
        };
    }
}
