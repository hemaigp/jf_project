package com.example.demo.controller;

import com.example.demo.model.UserDtls;
import com.example.demo.repository.userRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userRep repo;

    @ModelAttribute
    private  void userDetails(Model m, Principal p){
        String emailId=p.getName();
        UserDtls user = repo.findByEmailId(emailId);

        m.addAttribute("user",user);

    }

    @GetMapping("/")
    public String home(){
        return "user/home";
    }
}
