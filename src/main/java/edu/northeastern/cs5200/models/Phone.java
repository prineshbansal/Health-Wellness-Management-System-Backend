package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String phone;

  @JsonProperty
  private Boolean isPrimary;

  @ManyToOne()
//  @JsonIgnore
  private Person person;

  public Phone() {
  }

  public Phone(String phone, Boolean isPrimary) {
    this.phone = phone;
    this.isPrimary = isPrimary;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getPrimary() {
    return isPrimary;
  }

  public void setPrimary(Boolean primary) {
    isPrimary = primary;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
