package de.frakit.birthcertificate.registration;

import de.frakit.birthcertificate.email.EmailBuilder;
import de.frakit.birthcertificate.email.EmailSender;
import de.frakit.birthcertificate.email.EmailService;
import de.frakit.birthcertificate.registration.model.AppRole;
import de.frakit.birthcertificate.registration.model.AppUser;
import de.frakit.birthcertificate.registration.model.ConfirmationToken;
import de.frakit.birthcertificate.registration.token.ConfirmationTokenService;
import de.frakit.birthcertificate.registration.user.AppUserService;
import de.frakit.birthcertificate.registration.user.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private final EmailBuilder emailBuilder;

    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());
        if (!isValid) {
            throw new IllegalStateException("Email not valid");
        }

        String token = appUserService.signup(
                new AppUser(request.getFirstname(),
                        request.getEmail(),
                        request.getLastname(),
                        request.getPassword(),
                        AppRole.USER));

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;

        emailSender.send(request.getEmail(), emailBuilder.buildEmail(request.getFirstname(), token));
        return token;
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("Email already confirmed");
        }

        LocalDateTime expiresAt = confirmationToken.getExpiresAt();

        if(expiresAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token has expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return "confirmed";
    }
}
