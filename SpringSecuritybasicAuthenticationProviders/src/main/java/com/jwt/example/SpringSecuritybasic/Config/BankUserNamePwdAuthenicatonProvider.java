package com.jwt.example.SpringSecuritybasic.Config;

import com.jwt.example.SpringSecuritybasic.Entity.Customer;
import com.jwt.example.SpringSecuritybasic.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankUserNamePwdAuthenicatonProvider implements AuthenticationProvider {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email=authentication.getName();
        String password=authentication.getCredentials().toString();
        List<Customer> customer=customerRepository.findByEmail(email);
        if(customer.size()>0){
            if(password.equalsIgnoreCase(customer.get(0).getPassword())){
                List<GrantedAuthority> authorities=new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(email,password,authorities);
            }
            else{
                throw new BadCredentialsException("Invalid credentials");
            }

        }else{
            throw new BadCredentialsException("No user register with this credentials ");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
