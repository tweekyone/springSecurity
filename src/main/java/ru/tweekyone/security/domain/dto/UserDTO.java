package ru.tweekyone.security.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tweekyone.security.model.Role;
import ru.tweekyone.security.model.Sex;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstname;

    private String lastname;

    private Integer age;

    private String email;

    private Sex sex;

    private Set<Role> roles;
}
