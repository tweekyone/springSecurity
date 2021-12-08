package ru.tweekyone.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tweekyone.security.model.Role;
import ru.tweekyone.security.repository.RoleRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public Role getRole() {
        return roleRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException());
    }

}
