package com.cds.mx.apicds.person.model;
import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
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
    @Column
    private String ProfileImageUrl;
    @JsonIgnore
    @OneToOne(mappedBy = "person")
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "admissions_id")
    private Admissions admission;

    @ManyToMany(mappedBy = "personSkills")
    private List<Skills>personSkills;

    @ManyToMany(mappedBy = "personsProjects")
    private List<Projects>projects;

    public Person() {
    }

    public Person(long id, String cvFileUrl) {
        this.id = id;
        CvFileUrl = cvFileUrl;
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl) {
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
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl) {
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
    }

    public Person(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, Admissions admission) {
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
        this.admission = admission;
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, User user, Status status, Admissions admission) {
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
        this.user = user;
        this.status = status;
        this.admission = admission;
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, User user, Status status) {
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
        this.user = user;
        this.status = status;
    }

    public Person(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, User user, Status status) {
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
        this.user = user;
        this.status = status;
    }

    public Person(long id, String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status, Admissions admission, List<Skills> personSkills, List<Projects> projects) {
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

    public Person(String name, String lastname, String motherslastname, String dni, String email, String emailInstitutional, String cellphone, String phone, Address address, String scholl, String postulation, String cvFileUrl, String profileImageUrl, User user, Status status, Admissions admission, List<Skills> personSkills, List<Projects> projects) {
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

    public String getEmailInstitutional() {
        return emailInstitutional;
    }

    public void setEmailInstitutional(String emailInstitutional) {
        this.emailInstitutional = emailInstitutional;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Status getStatus() {
        return status;
    }

    public Admissions getAdmission() {
        return admission;
    }

    public void setAdmission(Admissions admission) {
        this.admission = admission;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCvFileUrl() {
        return CvFileUrl;
    }

    public void setCvFileUrl(String cvFileUrl) {
        CvFileUrl = cvFileUrl;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public List<Skills> getPersonSkills() {
        return personSkills;
    }

    public void setPersonSkills(List<Skills> personSkills) {
        this.personSkills = personSkills;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }
}
