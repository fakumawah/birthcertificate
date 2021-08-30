package de.frakit.birthcertificate.security;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static de.frakit.birthcertificate.security.ApplicationUserPermission.*;

@Getter
public enum ApplicationUserRole {
    SUPERADMIN(Sets.newHashSet(CITIZEN_CREATE, CITIZEN_READ, CITIZEN_UPDATE, CITIZEN_DELETE, ADDRESS_READ, ADDRESS_CREATE, ADDRESS_UPDATE, ADDRESS_UPDATE)),
    ADMIN(Sets.newHashSet(CITIZEN_CREATE, CITIZEN_READ, CITIZEN_UPDATE, ADDRESS_READ, ADDRESS_CREATE, ADDRESS_UPDATE)),
    MEMBER(Sets.newHashSet(CITIZEN_READ, ADDRESS_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
