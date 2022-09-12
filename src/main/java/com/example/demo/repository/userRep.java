package com.example.demo.repository;

import com.example.demo.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRep extends JpaRepository<UserDtls,Integer>
{
   public boolean existsByEmailId(String emailId);

   public UserDtls findByEmailId(String emailId);
}
