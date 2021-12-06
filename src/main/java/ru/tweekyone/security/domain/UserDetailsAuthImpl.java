package ru.tweekyone.security.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.tweekyone.security.model.Role;
import ru.tweekyone.security.model.Sex;
import ru.tweekyone.security.model.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
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
