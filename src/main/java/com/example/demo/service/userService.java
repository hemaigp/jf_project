package com.example.demo.service;

import com.example.demo.model.UserDtls;
public interface userService {

    public UserDtls createUser(UserDtls user);
    public boolean checkEmailId(String emailId);


}
