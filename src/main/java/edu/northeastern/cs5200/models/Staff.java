package edu.northeastern.cs5200.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "staff_id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Staff extends Person {
  private String status;

  @JsonProperty
  private Department department;
  private LocalDate joiningDate;

  @OneToOne(mappedBy = "staff", cascade = CascadeType.REMOVE)
  @JsonIgnore
  private Salary salary;

  public Staff() {
  }

  public Staff(
          String firstName,
          String lastName,
          String username,
          String password,
          LocalDate dateOfBirth,
          String gender) {
    super(firstName, lastName, username, password, dateOfBirth, gender);
  }

  public Staff(
          String firstName,
          String lastName,
          String username,
          String password,
          LocalDate dateOfBirth,
          String gender,
          String status,
          Department dept,
          LocalDate joiningDate) {
    super(firstName, lastName, username, password, dateOfBirth, gender);
    this.status = status;
    department = dept;
    this.joiningDate = joiningDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Salary getSalary() {
    return salary;
  }

  public void setSalary(Salary salary) {
    this.salary = salary;
  }
}
