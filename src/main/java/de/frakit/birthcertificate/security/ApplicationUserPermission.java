package de.frakit.birthcertificate.security;

import lombok.Getter;

@Getter
public enum ApplicationUserPermission {
    CITIZEN_CREATE("citizen:create"),
    CITIZEN_READ("citizen:read"),
    CITIZEN_UPDATE("citizen:update"),
    CITIZEN_DELETE("citizen:delete"),
    ADDRESS_CREATE("address:create"),
    ADDRESS_READ("address:read"),
    ADDRESS_UPDATE("address:update"),
    ADDRESS_DELETE("address:delete"),
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
}
