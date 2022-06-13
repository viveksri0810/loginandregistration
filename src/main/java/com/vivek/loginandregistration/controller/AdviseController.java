package com.vivek.loginandregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class AdviseController {

    @Autowired
    UserRegistrationController urc;

    @ExceptionHandler(org.springframework.validation.BindException.class)
    public String registerUserAccount(){
//       return urc.registerUserAccountFailure();
        return "redirect:/registration/signup?failure";
    }



}
