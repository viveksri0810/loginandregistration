package com.vivek.loginandregistration.dao.repository;

import com.vivek.loginandregistration.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole  extends JpaRepository<Role,Long> {
}
