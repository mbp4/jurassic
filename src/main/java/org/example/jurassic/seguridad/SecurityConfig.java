package org.example.jurassic.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain seguridadAccesos(HttpSecurity http) throws Exception{
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService seguridadUsuarios(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Miriam")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("Sira")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("Sonia")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("Invitado")
                .password(passwordEncoder().encode("1111"))
                .roles("USER")
                .build());

        return manager;

        //creamos un usuario para cada uno de los participantes y un invitado para poder acceder
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
