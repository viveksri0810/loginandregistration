package com.vivek.loginandregistration.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {


    private String firstName;
    private String lastName;
    @Email (message = "Email entered is not valid")
    private String email;
    private String password;
}
