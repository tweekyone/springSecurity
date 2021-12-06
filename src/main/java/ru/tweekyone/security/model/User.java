package ru.tweekyone.security.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private Integer age;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private boolean enabled;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NonNull
    @Column(name = "bday")
    private LocalDateTime bDay;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(@NonNull String firstname,
                @NonNull String lastname,
                @NonNull Integer age,
                @NonNull Sex sex,
                @NonNull String email,
                @NonNull LocalDateTime bDay,
                Set<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.bDay = bDay;
        this.roles = roles;
    }
}
