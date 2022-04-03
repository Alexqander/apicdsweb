package com.cds.mx.apicds.security.controller;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.role.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

public class UserDTO {

    private long id;
    private String username;
    private String password;
    private Person person;
    private Set<Role> roles;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String password, Person person, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public UserDTO(String username, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
