package com.example.demo.config;

import com.example.demo.model.UserDtls;
import com.example.demo.repository.userRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private userRep repo;


    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        UserDtls user =repo.findByEmailId(emailId);
        if(user !=null){
            return  new CustomerUserDetails(user);
        }
        throw new UsernameNotFoundException("user not available");
    }
}
