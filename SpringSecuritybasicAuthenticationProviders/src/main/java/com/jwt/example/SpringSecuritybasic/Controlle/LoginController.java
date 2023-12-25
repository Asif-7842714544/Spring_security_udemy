package com.jwt.example.SpringSecuritybasic.Controlle;

import com.jwt.example.SpringSecuritybasic.Entity.Customer;
import com.jwt.example.SpringSecuritybasic.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/saveUser")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
        ResponseEntity<String> response = null;
        try {
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() >= 0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("User Details are successfully registered");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + e.getMessage());
        }
        return response;
    }
}
