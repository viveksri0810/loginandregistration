package com.vivek.loginandregistration.controller;

import com.vivek.loginandregistration.dao.entity.User;
import com.vivek.loginandregistration.dto.UserRegistrationDto;
import com.vivek.loginandregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("signup")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("signup1")
    public String registerUserAccount(@Validated @ModelAttribute("user") UserRegistrationDto registrationDto){

            userService.save(registrationDto);
            return "redirect:/registration/signup?success";
    }

    public String registerUserAccountFailure(){

        return "redirect:/registration/signup?failure";
    }


}
