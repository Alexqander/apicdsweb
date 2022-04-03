package com.cds.mx.apicds.projects.model;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.status.model.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projects_id")
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int progress;


    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "persons_projects",
    joinColumns = @JoinColumn(name = "projects_id",referencedColumnName = "projects_id"),
    inverseJoinColumns = @JoinColumn(name = "person_id",referencedColumnName = "person_id"))
    private List<Person>personsProjects;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Projects() {
    }

    public Projects(String name, String description, Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Projects(String name, String description, int progress, Status status) {
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.status = status;
    }

    public Projects(long id, String name, String description, int progress, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.status = status;
    }

    public Projects(long id, String name, String description, int progress, List<Person> personsProjects, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.personsProjects = personsProjects;
        this.status = status;
    }

    public Projects(String name, String description, int progress, List<Person> personsProjects, Status status) {
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.personsProjects = personsProjects;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public List<Person> getPersonsProjects() {
        return personsProjects;
    }

    public void setPersonsProjects(List<Person> personsProjects) {
        this.personsProjects = personsProjects;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
