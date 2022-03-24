package com.example.logindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginDemoController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersRepository uRepo;

    @GetMapping("/login")
    public String getLogin(){
        Users user = new Users();
        user.setUsername("user");
        String blankPassword = "Passwort1!";
        user.setPassword(passwordEncoder.encode(blankPassword));
        Authorities userAuthority = new Authorities();
        userAuthority.setUsername("user");
        userAuthority.setAuthority("ROLE_user");
        user.setEnabled(true);

        user.setAuthority(userAuthority);

        uRepo.save(user);
        return "login";
    }

    @GetMapping("/startpage")
    public String getStartpage(){
        return "startpage";
    }

}
