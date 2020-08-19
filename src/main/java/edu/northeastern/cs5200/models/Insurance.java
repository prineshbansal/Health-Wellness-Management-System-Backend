package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "insurances")
public class Insurance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Patient patient;

  private String insuranceDetails;
  private String insuranceType;

  public Insurance() {}

  public Insurance(String insuranceDetails, String insuranceType) {
    this.insuranceDetails = insuranceDetails;
    this.insuranceType = insuranceType;
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

  public String getInsuranceDetails() {
    return insuranceDetails;
  }

  public void setInsuranceDetails(String insuranceDetails) {
    this.insuranceDetails = insuranceDetails;
  }

  public String getInsuranceType() {
    return insuranceType;
  }

  public void setInsuranceType(String insuranceType) {
    this.insuranceType = insuranceType;
  }
}
