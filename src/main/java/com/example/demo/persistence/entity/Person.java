package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PersonAddress> addresses = new ArrayList<>();

    public Person(Long id, String registrationNumber, List<PersonAddress> addresses) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.addresses = addresses;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<PersonAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PersonAddress> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        PersonAddress personAddress = new PersonAddress(this, address);
        addresses.add(personAddress);
        address.getOwners().add(personAddress);
    }

    public void removeAddress(Address address) {
        PersonAddress personAddress = new PersonAddress(this, address);
        address.getOwners().remove(personAddress);
        addresses.remove(personAddress);
        personAddress.setPerson(null);
        personAddress.setAddress(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(registrationNumber, person.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
