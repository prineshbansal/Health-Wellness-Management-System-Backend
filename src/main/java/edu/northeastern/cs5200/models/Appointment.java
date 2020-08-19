package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
//  @JsonIgnore
  private Patient patient;

  @ManyToOne
//  @JsonIgnore
  private Doctor doctor;


  private String notes;
  private String time;

  @JsonProperty
  private LocalDate dateOfAppointment;

  public Appointment() {
  }

  public Appointment(String notes, String time, LocalDate dateOfAppointment) {
    this.notes = notes;
    this.time = time;
    this.dateOfAppointment = dateOfAppointment;
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

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public LocalDate getDateOfAppointment() {
    return dateOfAppointment;
  }

  public void setDateOfAppointment(LocalDate date) {
    this.dateOfAppointment = date;
  }
}
