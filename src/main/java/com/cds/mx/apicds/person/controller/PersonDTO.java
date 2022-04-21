package com.cds.mx.apicds.person.controller;

import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.user.model.User;

import java.util.List;

public class PersonDTO {
    private long id;
    private String name;
    private String lastname;
    private String motherslastname;
    private String dni;
    private String email;
    private String emailInstitutional;
    private String cellphone;
    private String phone;
    private Address address;
    private String scholl;
    private String postulation;
    private String CvFileUrl;
    private String ProfileImageUrl;
    private User user;
    private Status status;
    private Admissions admission;
    private Skills personSkills;
    private Projects projects;

    public PersonDTO() {
    }

    public PersonDTO(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status, Admissions admission, Skills personSkills, Projects projects) {
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
        ProfileImageUrl = profileImageUrl;
        this.user = user;
        this.status = status;
        this.admission = admission;
        this.personSkills = personSkills;
        this.projects = projects;
    }

    public PersonDTO(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status, Admissions admission, Skills personSkills, Projects projects) {
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
        this.postulation = postulation;
        CvFileUrl = cvFileUrl;
        ProfileImageUrl = profileImageUrl;
        this.user = user;
        this.status = status;
        this.admission = admission;
        this.personSkills = personSkills;
        this.projects = projects;
    }

    public PersonDTO(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status) {
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
        this.postulation = postulation;
        CvFileUrl = cvFileUrl;
        ProfileImageUrl = profileImageUrl;
        this.user = user;
        this.status = status;
    }

    public PersonDTO(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status) {
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
        ProfileImageUrl = profileImageUrl;
        this.user = user;
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
        return this.CvFileUrl;
    }

    public void setCvFileUrl(String cvFileUrl) {
        this.CvFileUrl = cvFileUrl;
    }

    public String getProfileImageUrl() {
        return this.ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.ProfileImageUrl = profileImageUrl;
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

    public Skills getPersonSkills() {
        return personSkills;
    }

    public void setPersonSkills(Skills personSkills) {
        this.personSkills = personSkills;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
}
