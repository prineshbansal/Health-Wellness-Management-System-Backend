package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private LocalDate dateOfBirth;
  private String Gender;

  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JsonIgnore
  private Set<Address> addresses;

  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JsonIgnore
  private Set<Phone> phones;


  public Person() {
  }

  public Person(String firstName, String lastName, String username,
                String password, LocalDate dateOfBirth, String gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.dateOfBirth = dateOfBirth;
    Gender = gender;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return Gender;
  }

  public void setGender(String gender) {
    Gender = gender;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  public Set<Phone> getPhones() {
    return phones;
  }

  public void setPhones(Set<Phone> phones) {
    this.phones = phones;
  }
}
