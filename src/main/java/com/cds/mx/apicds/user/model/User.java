package com.cds.mx.apicds.user.model;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.role.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 50)
    private String username;
    @Column(nullable = false )
    @JsonIgnore
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "users")
    private Set<Role>roles;

    public User() {
    }

    public User(long id, String username, String password, Person person, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public User(String username, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public User(String username, String password) {
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
