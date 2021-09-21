package de.frakit.birthcertificate.registration.user;


import de.frakit.birthcertificate.registration.model.AppUser;
import de.frakit.birthcertificate.registration.model.ConfirmationToken;
import de.frakit.birthcertificate.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
     private final static String USER_NOT_FOUNT= "User with email %s not found";
     private final static String EMAIL_ALREADY_TAKEN= "Email %s already taken";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUNT, email)));
    }

    public String signup(AppUser appUser){
        String email = appUser.getEmail();
        boolean userExist = appUserRepository.findByEmail(email).isPresent();
        if(userExist){
            throw new IllegalStateException(String.format(EMAIL_ALREADY_TAKEN, email));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser);

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;

        // TODO send email with token

    }
}
