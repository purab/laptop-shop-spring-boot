package com.pkharat.laptopshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private String address;

    private String city;

    private String postalCode;

    private boolean isEnabled;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

   


}
