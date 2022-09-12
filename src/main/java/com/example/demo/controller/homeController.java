package com.example.demo.controller;

import com.example.demo.model.UserDtls;

import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class homeController {

    @Autowired
    private userService service;

    @GetMapping("/")
    public String home(){

        return "index";
    }
    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/registation")
    public String register()
    {
        return "registation";
    }
    @PostMapping ("/AddUser")
    public String createUser(@ModelAttribute UserDtls user, HttpSession session)
    {
        boolean f=service.checkEmailId(user.getEmailId());

        if(f){
            session.setAttribute("msg","Email Id already Exits");
              // System.out.println("Email id already Exit");
        }
        else {

            UserDtls userDtls = service.createUser(user);
            //System.out.println(user);
            if (userDtls != null) {
                session.setAttribute("msg","Register Successfully");
               // System.out.println("Register Sucessfully....");
            } else {
               // System.out.println("Something error in server ");
                session.setAttribute("msg","Something wrong on server");
            }
        }
        return "redirect:/registation";
    }

}
