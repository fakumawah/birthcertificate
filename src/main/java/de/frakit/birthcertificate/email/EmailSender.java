package de.frakit.birthcertificate.email;

public interface EmailSender {
    void send(String to, String email);
}
