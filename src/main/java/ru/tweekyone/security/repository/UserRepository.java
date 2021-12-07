package ru.tweekyone.security.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tweekyone.security.domain.UserDetailsAuthImpl;
import ru.tweekyone.security.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> getUserByName(String name);

    @EntityGraph(attributePaths = "{roles}")
    Optional<UserDetailsAuthImpl > getUserByEmail(String email);
}
