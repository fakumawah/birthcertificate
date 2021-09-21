package de.frakit.birthcertificate.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {

    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;
}
