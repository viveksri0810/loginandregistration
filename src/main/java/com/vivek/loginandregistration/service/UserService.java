package com.vivek.loginandregistration.service;


import com.vivek.loginandregistration.dao.entity.Role;
import com.vivek.loginandregistration.dao.entity.User;
import com.vivek.loginandregistration.dao.repository.IUser;
import com.vivek.loginandregistration.dto.UserRegistrationDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUser iUser;

    @Autowired
    public BCryptPasswordEncoder apasswordEncoder;

    @Override
    public User save(UserRegistrationDto uRD) {

        User user=new User(uRD.getFirstName(), uRD.getLastName(), uRD.getEmail(), apasswordEncoder.encode(uRD.getPassword()), Arrays.asList(new Role("Role_User")));

        return iUser.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = iUser.findByEmail(username);
         if(user == null){
             throw new UsernameNotFoundException("Invalid username or password");
         }

         return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRoleToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities (Collection<Role> roles){
      return   roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
