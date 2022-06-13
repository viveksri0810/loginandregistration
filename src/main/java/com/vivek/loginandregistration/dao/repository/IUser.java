package com.vivek.loginandregistration.dao.repository;

import com.vivek.loginandregistration.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Long> {


    User findByEmail(String email);
}
