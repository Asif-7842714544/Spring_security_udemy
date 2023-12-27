package com.jwt.example.SpringSecuritybasic.Config;

import com.jwt.example.SpringSecuritybasic.Config.Filer.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    public static final String[] PROTECTED_APIS = {"/myaccount", "/myloans", "/mybalance", "/mycards"};
    public static final String[] PUBLIC_APIS = {"/contact", "/notice", "/saveUser"};

    CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        Custom security configuration
        http
                //To always create a new JsessionId
                .securityContext(s -> s.requireExplicitSave(false))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }))
                .csrf(c -> c
                        .csrfTokenRequestHandler(requestAttributeHandler)
                        .ignoringRequestMatchers("/contact", "/saveUser")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)

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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
