package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "salary_details")
public class Salary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private long baseSalary;
  private int allowances;
  private int epf;

  @OneToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "salary_id", referencedColumnName = "staff_id")
  private Staff staff;

  public Salary() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Salary(long baseSalary, int allowances, int epf, Staff staff) {
    this.baseSalary = baseSalary;
    this.allowances = allowances;
    this.epf = epf;
    this.staff = staff;
  }

  public Salary(long baseSalary, int allowances, int epf) {
    this.baseSalary = baseSalary;
    this.allowances = allowances;
    this.epf = epf;
  }

  public long getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(long baseSalary) {
    this.baseSalary = baseSalary;
  }

  public int getAllowances() {
    return allowances;
  }

  public void setAllowances(int allowances) {
    this.allowances = allowances;
  }

  public int getEpf() {
    return epf;
  }

  public void setEpf(int epf) {
    this.epf = epf;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }
}
