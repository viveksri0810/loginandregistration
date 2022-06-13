package com.vivek.loginandregistration.service;

import com.vivek.loginandregistration.dao.entity.User;
import com.vivek.loginandregistration.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    public  User save(UserRegistrationDto uRD);
}
