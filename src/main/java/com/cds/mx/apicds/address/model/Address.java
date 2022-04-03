package com.cds.mx.apicds.address.model;

import com.cds.mx.apicds.person.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String street;
    @Column
    private int extNumber;
    @Column
    private int intNumber;
    @Column
    private String colonia;
    @Column
    private int postalCode;
    @Column
    private String town;
    @Column
    private String estate;


    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Person person;

    public Address() {
    }

    public Address(long id, String street, int extNumber, int intNumber, String colonia, int postalCode, String town, String estate) {
        this.id = id;
        this.street = street;
        this.extNumber = extNumber;
        this.intNumber = intNumber;
        this.colonia = colonia;
        this.postalCode = postalCode;
        this.town = town;
        this.estate = estate;
    }

    public Address(String street, int extNumber, int intNumber, String colonia, int postalCode, String town, String estate) {
        this.street = street;
        this.extNumber = extNumber;
        this.intNumber = intNumber;
        this.colonia = colonia;
        this.postalCode = postalCode;
        this.town = town;
        this.estate = estate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getExtNumber() {
        return extNumber;
    }

    public void setExtNumber(int extNumber) {
        this.extNumber = extNumber;
    }

    public int getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(int intNumber) {
        this.intNumber = intNumber;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }
}
