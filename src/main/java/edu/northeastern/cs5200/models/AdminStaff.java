package edu.northeastern.cs5200.models;


import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AdminStaff extends Staff {
  private String jobTitle;
  private String jobDescription;

  public AdminStaff() {
    super();
  }

  public AdminStaff(String firstName, String lastName,
                    String username, String password, LocalDate dateOfBirth,
                    String gender) {
    super(firstName, lastName, username, password, dateOfBirth, gender);
  }

  public AdminStaff(String firstName, String lastName, String username, String password,
                    LocalDate dateOfBirth, String gender, String status, Department dept, LocalDate joiningDate,
                    String jobTitle, String jobDescription) {
    super(firstName, lastName, username, password, dateOfBirth, gender, status, dept, joiningDate);
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }
}
