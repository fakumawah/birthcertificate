package de.frakit.birthcertificate.registration;

import de.frakit.birthcertificate.registration.model.AppRole;
import de.frakit.birthcertificate.registration.model.AppUser;
import de.frakit.birthcertificate.registration.user.AppUserService;
import de.frakit.birthcertificate.registration.user.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;
    private AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());
        if (!isValid) {
            throw new IllegalStateException("Email not valid");
        }
        return appUserService.signup(
                new AppUser(request.getFirstname(),
                        request.getEmail(),
                        request.getLastname(),
                        request.getPassword(),
                        AppRole.USER));
    }
}
