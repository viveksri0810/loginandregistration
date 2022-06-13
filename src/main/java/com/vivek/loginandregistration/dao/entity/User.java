package com.vivek.loginandregistration.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "user", uniqueConstraints  = @UniqueConstraint(columnNames = {"email"}) )
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;
        @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_role",
                joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name ="role_id",referencedColumnName = "id")
        )
        @Column(name = "roles")
        private Collection<Role> roles;


        public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.password = password;
                this.roles = roles;
        }
}
