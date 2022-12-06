package br.com.javatos.web.security;

import br.com.javatos.web.repository.UsuarioRepository;
import br.com.javatos.web.security.login.UserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UsuarioRepository usuarioRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/image/**").permitAll()
                .antMatchers("/usuario").permitAll()
//                .antMatchers("/usuario/listar").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()
                .successForwardUrl("/tarefa/listar")
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("a@a")
//                .password(passwordEncoder.encode("123456"))
//                .roles("OUTRO")
//                .and()
//                .withUser("admin@admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN");
        auth
                .userDetailsService(email ->
                        new UserLogin(usuarioRepository.findByEmail(email)));
    }
}
