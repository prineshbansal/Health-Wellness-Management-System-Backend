package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "allergies")
public class Allergy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Patient patient;

  private String allergyInfo;
  private String allergyCause;

  public Allergy() {}

  public Allergy(String allergyInfo, String allergyCause) {
    this.allergyInfo = allergyInfo;
    this.allergyCause = allergyCause;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public String getAllergyInfo() {
    return allergyInfo;
  }

  public void setAllergyInfo(String allergyInfo) {
    this.allergyInfo = allergyInfo;
  }

  public String getAllergyCause() {
    return allergyCause;
  }

  public void setAllergyCause(String allergyCause) {
    this.allergyCause = allergyCause;
  }
}
