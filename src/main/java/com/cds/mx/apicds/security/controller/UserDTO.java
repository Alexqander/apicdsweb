package com.cds.mx.apicds.security.controller;


import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.role.model.Role;

import java.util.Set;

public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Set<Role> roles;
    private Person person;

    public UserDTO() {
    }

    public UserDTO(String username, String password, Set<Role> roles, Person person) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.person = person;
    }

    public UserDTO(long id, String username, String password, Set<Role> roles, Person person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}