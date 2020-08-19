package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  //  @JsonIgnore
  private Patient patient;

  @ManyToOne
//  @JsonIgnore
  private Doctor doctor;

  @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private List<Medication> medications;

  @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private List<MedicalTest> medicalTests;

  private LocalDate prescriptionDate;
  private String refillData;

  @JsonProperty
  private Boolean substitutionPermitted;

  public Prescription() {
  }

  public Prescription(
          LocalDate prescriptionDate,
          String refillData,
          Boolean substitutionPermitted) {
    this.prescriptionDate = prescriptionDate;
    this.refillData = refillData;
    this.substitutionPermitted = substitutionPermitted;
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

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public LocalDate getPrescriptionDate() {
    return prescriptionDate;
  }

  public void setPrescriptionDate(LocalDate prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
  }

  public String getRefillData() {
    return refillData;
  }

  public void setRefillData(String refillData) {
    this.refillData = refillData;
  }

  public Boolean getSubstitutionPermitted() {
    return substitutionPermitted;
  }

  public void setSubstitutionPermitted(Boolean substitutionPermitted) {
    this.substitutionPermitted = substitutionPermitted;
  }

  public List<Medication> getMedications() {
    return medications;
  }

  public void setMedications(List<Medication> medications) {
    this.medications = medications;
  }

  public List<MedicalTest> getMedicalTests() {
    return medicalTests;
  }

  public void setMedicalTests(List<MedicalTest> medicalTests) {
    this.medicalTests = medicalTests;
  }
}
