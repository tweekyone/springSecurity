package ru.tweekyone.security.domain;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.tweekyone.security.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserDetailsAuthImpl extends User implements UserDetails {

    public UserDetailsAuthImpl(User user) {
        super(
                user.getFirstname(),
                user.getLastname(),
                user.getAge(),
                user.getPassword(),
                user.getSex(),
                user.getEmail(),
                user.isEnabled(),
                user.getBDay(),
                user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles().stream()
                .map(role -> new RolesGrantedAuthorities(role.getId(), role.getRole()))
                .collect(Collectors.toSet());
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
