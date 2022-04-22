package com.cds.mx.apicds.person.model;
import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private String motherslastname;
    @Column
    private String dni;
    @Column
    private String email;
    @Column
    private String emailInstitutional;
    @Column
    private String cellphone;
    @Column
    private String phone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column
    private String scholl;
    @Column
    private String postulation;
    @Column
    private String CvFileUrl;
    @JsonIgnore
    @OneToOne(mappedBy = "person")
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admissions_id")
    private Admissions admission;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "person_skills",
            joinColumns = { @JoinColumn(name = "id_person") },
            inverseJoinColumns = { @JoinColumn(name = "id_skill") })
    private Set<Skills> skills = new HashSet<>();
    //skilss

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "person_projects",
            joinColumns = { @JoinColumn(name = "id_person") },
            inverseJoinColumns = { @JoinColumn(name = "id_project") })
    private Set<Projects> projects = new HashSet<>();



    //metodo para insertar el projecto a la union de muchos a muchos

    public void addProject(Projects project){
        this.projects.add(project);
        project.getPersons().add(this);
    }

    //metodo para insertar una skill en la relacion muchos a muchos.

    public void addSkill(Skills skill){
        this.skills.add(skill);
        skill.getPersons().add(this);
    }

    public Person() {
    }

    public Person(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, Admissions admission) {
        this.name = name;
        this.lastname = lastname;
        this.motherslastname = motherslastname;
        this.dni = dni;
        this.email = email;
        this.emailInstitutional = emailInstitutional;
        this.cellphone = cellphone;
        this.phone = phone;
        this.address = address;
        this.scholl = scholl;
        this.postulation = postulation;
        CvFileUrl = cvFileUrl;
        this.admission = admission;
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.motherslastname = motherslastname;
        this.dni = dni;
        this.email = email;
        this.emailInstitutional = emailInstitutional;
        this.cellphone = cellphone;
        this.phone = phone;
        this.address = address;
        this.scholl = scholl;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMotherslastname() {
        return motherslastname;
    }

    public void setMotherslastname(String motherslastname) {
        this.motherslastname = motherslastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailInstitutional() {
        return emailInstitutional;
    }

    public void setEmailInstitutional(String emailInstitutional) {
        this.emailInstitutional = emailInstitutional;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getScholl() {
        return scholl;
    }

    public void setScholl(String scholl) {
        this.scholl = scholl;
    }

    public String getPostulation() {
        return postulation;
    }

    public void setPostulation(String postulation) {
        this.postulation = postulation;
    }

    public String getCvFileUrl() {
        return CvFileUrl;
    }

    public void setCvFileUrl(String cvFileUrl) {
        CvFileUrl = cvFileUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Admissions getAdmission() {
        return admission;
    }

    public void setAdmission(Admissions admission) {
        this.admission = admission;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }
}


