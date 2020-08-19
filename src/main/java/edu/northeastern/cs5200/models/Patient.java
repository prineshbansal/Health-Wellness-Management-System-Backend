package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends Person {

  private String medicalHistory;
  private LocalDate dateOfAdmission;

  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Allergy> allergies;

  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Set<Insurance> insurances;

  @JsonIgnore
  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Appointment> appointments;

  @JsonIgnore
  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Prescription> prescriptions;

  public Patient() {
  }

  public Patient(
          String firstName,
          String lastName,
          String username,
          String password,
          LocalDate dateOfBirth,
          String gender) {
    super(firstName, lastName, username, password, dateOfBirth, gender);
  }

  public Patient(
          String firstName,
          String lastName,
          String username,
          String password,
          LocalDate dateOfBirth,
          String gender,
          String medicalHistory,
          LocalDate dateOfAdmission
  ) {
    super(firstName, lastName, username, password, dateOfBirth, gender);
    this.medicalHistory = medicalHistory;
    this.dateOfAdmission = dateOfAdmission;
  }

  public String getMedicalHistory() {
    return medicalHistory;
  }

  public void setMedicalHistory(String medicalHistory) {
    this.medicalHistory = medicalHistory;
  }

  public LocalDate getDateOfAdmission() {
    return dateOfAdmission;
  }

  public void setDateOfAdmission(LocalDate dateOfAdmission) {
    this.dateOfAdmission = dateOfAdmission;
  }

  public Set<Allergy> getAllergies() {
    return allergies;
  }

  public void setAllergies(Set<Allergy> allergies) {
    this.allergies = allergies;
  }

  public Set<Insurance> getInsurances() {
    return insurances;
  }

  public void setInsurances(Set<Insurance> insurances) {
    this.insurances = insurances;
  }

  public Set<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(Set<Appointment> appointments) {
    this.appointments = appointments;
  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }
}
