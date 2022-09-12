package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="registration")
public class UserDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="userName")
    private String userName;

    @Column(name = "password")
    @NotNull()
    @Length(min = 5, message = "Password should be atleast 5 characters long")
    private  String password;

    @Column(name ="emailId")
    @NotNull()
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Email cannot be empty")
    private String emailId;

    @Column(name="phoneNumber")
    private long phoneNumber;

    private String role;

}
