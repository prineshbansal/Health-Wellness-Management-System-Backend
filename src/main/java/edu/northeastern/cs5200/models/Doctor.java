package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor extends Staff {
  private String designation;
  private String education;
  private String certification;

  @JsonIgnore
  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Prescription> prescriptions;

  @JsonIgnore
  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Appointment> appointments;

  public Set<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(Set<Appointment> appointments) {
    this.appointments = appointments;
  }

  public Doctor() {

  }

  public Doctor(String firstName, String lastName, String username, String password,
                LocalDate dateOfBirth, String gender, String status, Department dept, LocalDate joiningDate) {
    super(firstName, lastName, username, password, dateOfBirth, gender, status, dept, joiningDate);
  }

  public Doctor(String firstName, String lastName, String username, String password,
                LocalDate dateOfBirth, String gender, String status, Department dept, LocalDate joiningDate,
                String designation, String education, String certification) {
    super(firstName, lastName, username, password, dateOfBirth, gender, status, dept, joiningDate);
    this.designation = designation;
    this.education = education;
    this.certification = certification;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getCertification() {
    return certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }
}
