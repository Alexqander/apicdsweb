package com.cds.mx.apicds.role.model;

import com.cds.mx.apicds.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 20)
    private String description;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<User> users;

    public Role() {
    }

    public Role(long id, String description, Set<User> users) {
        this.id = id;
        this.description = description;
        this.users = users;
    }

    public Role(String description, Set<User> users) {
        this.description = description;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
