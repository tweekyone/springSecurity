package ru.tweekyone.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tweekyone.security.model.Role;
import ru.tweekyone.security.service.RoleService;

@RestController
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<Role> getRole() {
        return new ResponseEntity<>(roleService.getRole(), HttpStatus.OK);
    }
}
