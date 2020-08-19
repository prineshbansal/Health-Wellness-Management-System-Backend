package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medical_tests")
public class MedicalTest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JsonIgnore
  private Prescription prescription;

  private String testType;
  private String testResults;
  private LocalDate testDate;

  public MedicalTest() {
  }

  public MedicalTest(String testType, String testResults, LocalDate testDate) {
    this.testType = testType;
    this.testResults = testResults;
    this.testDate = testDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Prescription getPrescription() {
    return prescription;
  }

  public void setPrescription(Prescription prescription) {
    this.prescription = prescription;
  }

  public String getTestType() {
    return testType;
  }

  public void setTestType(String testType) {
    this.testType = testType;
  }

  public String getTestResults() {
    return testResults;
  }

  public void setTestResults(String testResults) {
    this.testResults = testResults;
  }

  public LocalDate getTestDate() {
    return testDate;
  }

  public void setTestDate(LocalDate testDate) {
    this.testDate = testDate;
  }
}
