package ru.tweekyone.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.tweekyone.security.domain.UserDetailsAuthImpl;
import ru.tweekyone.security.domain.dto.UserDTO;
import ru.tweekyone.security.model.User;
import ru.tweekyone.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User saveUser(UserDTO userDto) {
        User user = new User(userDto.getFirstname(), userDto.getLastname(), userDto.getAge(), userDto.getPassword(),
                userDto.getSex(), userDto.getEmail(), LocalDateTime.now(), userDto.getRoles());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public User getUserByName(String name) {
        return userRepository.getUserByName(name).orElseThrow(() -> new RuntimeException());
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByName(email).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserDetailsAuthImpl userDetails = userRepository.getUserByEmail(userEmail)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("User with Email %s not found", userEmail)));
        return userDetails;
    }
}
