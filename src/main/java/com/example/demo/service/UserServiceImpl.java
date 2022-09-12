package com.example.demo.service;

import com.example.demo.model.UserDtls;
import com.example.demo.repository.userRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements userService{

    @Autowired
    private userRep repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public UserDtls createUser(UserDtls user) {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return repo.save(user);
    }

    @Override
    public boolean checkEmailId(String emailId) {
        return  repo.existsByEmailId(emailId);
    }

}
