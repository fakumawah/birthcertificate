package de.frakit.birthcertificate.security.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static de.frakit.birthcertificate.security.old.ApplicationUserRole.*;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig {//extends WebSecurityConfigurerAdapter {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //@Override
    //@Bean
    protected UserDetailsService userDetailsService() {
        UserDetails fruUser = User.builder()
                .username("fru")
                .password(passwordEncoder.encode("password"))
                .roles(MEMBER.name())
                .build();

        UserDetails superAdminUser = User.builder()
                .username("superadmin")
                .password(passwordEncoder.encode("superpassword"))
                .roles(SUPERADMIN.name())
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("adminpassword"))
                .roles(ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(fruUser, adminUser, superAdminUser);
    }

    // Implementing basic authentication
   // @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(MEMBER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
