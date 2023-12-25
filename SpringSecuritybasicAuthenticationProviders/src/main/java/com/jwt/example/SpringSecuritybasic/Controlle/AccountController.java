package com.jwt.example.SpringSecuritybasic.Controlle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myaccount")
    public String getAccountdetails(){
        return "";
    }
}
