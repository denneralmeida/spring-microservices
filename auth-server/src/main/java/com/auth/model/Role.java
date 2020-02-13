package com.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ROLE_ADMIN");

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
