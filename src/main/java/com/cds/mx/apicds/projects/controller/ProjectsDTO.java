package com.cds.mx.apicds.projects.controller;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.status.model.Status;

import javax.persistence.*;
import java.util.List;

public class ProjectsDTO {
    private long id;
    private String name;
    private String description;
    private int progress;
    private List<Person> personsProjects;
    private Status status;

    public ProjectsDTO() {
    }

    public ProjectsDTO(String name, String description, Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public ProjectsDTO(long id, String name, String description, int progress, List<Person> personsProjects, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.personsProjects = personsProjects;
        this.status = status;
    }

    public ProjectsDTO(String name, String description, int progress, List<Person> personsProjects, Status status) {
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
