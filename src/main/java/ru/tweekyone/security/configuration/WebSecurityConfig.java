package ru.tweekyone.security.configuration;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.tweekyone.security.service.UserService;

@Configuration
@ComponentScan("ru.tweekyone.security.security")
@EnableWebSecurity
@NoArgsConstructor
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    public void configureGlobalAuth(final AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
    }
}
