package com.jwt.example.SpringSecuritybasic.Controlle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/myloans")
    public String getLoanDetails() {
        return "";
    }
}
