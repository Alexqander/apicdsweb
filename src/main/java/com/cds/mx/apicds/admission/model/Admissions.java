package com.cds.mx.apicds.admission.model;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.status.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Admissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String description;
    @Column
    private String startDate;
    @Column
    private String endDate;

    @OneToMany(mappedBy = "admission")
    @JsonIgnore
    private List<Person>persons;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Admissions() {
    }

    public Admissions(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Admissions(String description, String startDate, String endDate, Status status) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Admissions(String description, String startDate, String endDate, List<Person> persons, Status status) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
        this.status = status;
    }

    public Admissions(long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Admissions(long id, String description, String startDate, String endDate, List<Person> persons) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
    }

    public Admissions(String description, String startDate, String endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Admissions(long id, String description, String startDate, String endDate) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
