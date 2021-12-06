package ru.tweekyone.security.domain;

import org.springframework.security.core.GrantedAuthority;
import ru.tweekyone.security.model.Role;

public class RolesGrantedAuthorities extends Role implements GrantedAuthority {

    public RolesGrantedAuthorities(Long id, String authorities) {
        super(id, authorities);
    }

    @Override
    public String getAuthority() {
        return super.getRole();
    }
}
