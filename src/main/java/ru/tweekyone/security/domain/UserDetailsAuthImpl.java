package ru.tweekyone.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.tweekyone.security.model.User;

import java.util.Collection;

public class UserDetailsAuthImpl extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isEnabled();
    }
}
