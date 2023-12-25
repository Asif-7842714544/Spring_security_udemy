package com.jwt.example.SpringSecuritybasic.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    public static final String[] PROTECTED_APIS = {"/myaccount", "/myloans", "/mybalance", "/mycards"};
    public static final String[] PUBLIC_APIS = {"/contact", "/notice","/saveUser"};

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        Custom security configuration
        http
                .csrf(c->c.disable())
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(PROTECTED_APIS).authenticated()
                .requestMatchers(PUBLIC_APIS).permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();

        // denying all requests
//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().denyAll())
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();

        // permitting all requests
//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().permitAll())
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();

    }

    //User details from inMemory Cache
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager (){
//        UserDetails user= User.builder().username("Asif").password(passwordEncoder().encode("Asif")).authorities("ADMIN").build();
//        UserDetails user1= User.builder().username("Arshad").password(passwordEncoder().encode("Arshad")).authorities("READER").build();
//        return  new InMemoryUserDetailsManager(user,user1);
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
