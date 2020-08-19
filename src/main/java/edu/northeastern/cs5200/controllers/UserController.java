package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class UserController {

  @Autowired UserRepository userRepository;

  @Autowired HospitalDao hospitalDao;

  @PostMapping("/register")
  public User register(HttpSession session, @RequestBody User user) {
    if (userRepository.findUserByUsername(user.getUsername()) != null) {
      return null;
    } else {
      if (user.getUserType().equals("Patient") && user.getUserKey().equals("abc123")) {
        User newUser = userRepository.save(user);
        session.setAttribute("profile", newUser);
        return newUser;
      } else if (user.getUserType().equals("Doctor") && user.getUserKey().equals("def456")) {
        User newUser = userRepository.save(user);
        session.setAttribute("profile", newUser);
        return newUser;
      } else if (user.getUserType().equals("Admin Staff") && user.getUserKey().equals("ghi789")) {
        User newUser = userRepository.save(user);
        //        user.setPassword("****");
        session.setAttribute("profile", newUser);
        return newUser;
      } else return null;
    }
  }

  @PostMapping("/login")
  public User login(HttpSession session, @RequestBody User user) {
    User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
    session.setAttribute("profile", profile);
    return profile;
  }

  @PostMapping("/profile")
  public User profile(HttpSession session) {
    User profile = (User) session.getAttribute("profile");
    return profile;
  }

  @PostMapping("/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @PostMapping("/api/patient/create")
  public Patient createPatient(HttpSession session, @RequestBody Patient patient) {
    Patient newPatient = hospitalDao.createPatient(patient);
    session.setAttribute("patient", newPatient);
    return newPatient;
  }

  @PutMapping("/api/patient/update/{username}")
  public Patient updatePatient(
      HttpSession session,
      @RequestBody Patient updatedPatient,
      @PathVariable("username") String username) {
    Patient prevPatient = hospitalDao.findPatientByUsername(username);
    prevPatient.setFirstName(updatedPatient.getFirstName());
    prevPatient.setLastName(updatedPatient.getLastName());
    prevPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
    prevPatient.setGender(updatedPatient.getGender());
    prevPatient.setMedicalHistory(updatedPatient.getMedicalHistory());
    prevPatient.setDateOfAdmission(updatedPatient.getDateOfAdmission());
    session.setAttribute("patient", updatedPatient);
    return hospitalDao.createPatient(prevPatient);
  }

  @PostMapping("/api/doctor/create")
  public Doctor createDoctor(HttpSession session, @RequestBody Doctor doctor) {
    Doctor newDoctor = hospitalDao.createDoctor(doctor);
    session.setAttribute("doctor", newDoctor);
    return newDoctor;
  }

  @PutMapping("/api/doctor/update/{username}")
  public Doctor updateDoctor(
      HttpSession session,
      @RequestBody Doctor updatedDoctor,
      @PathVariable("username") String username) {
    Doctor prevDoctor = hospitalDao.findDoctorByUsername(username);
    prevDoctor.setFirstName(updatedDoctor.getFirstName());
    prevDoctor.setLastName(updatedDoctor.getLastName());
    prevDoctor.setDateOfBirth(updatedDoctor.getDateOfBirth());
    prevDoctor.setGender(updatedDoctor.getGender());
    prevDoctor.setStatus(updatedDoctor.getStatus());
    prevDoctor.setDepartment(updatedDoctor.getDepartment());
    prevDoctor.setJoiningDate(updatedDoctor.getJoiningDate());
    prevDoctor.setDesignation(updatedDoctor.getDesignation());
    prevDoctor.setEducation(updatedDoctor.getEducation());
    prevDoctor.setCertification(updatedDoctor.getCertification());
    session.setAttribute("updatedDoctor", updatedDoctor);
    return hospitalDao.createDoctor(prevDoctor);
  }

  @PostMapping("/api/adminStaff/create")
  public AdminStaff createAdminStaff(HttpSession session, @RequestBody AdminStaff adminStaff) {
    AdminStaff newStaff = hospitalDao.createAdminStaff(adminStaff);
    session.setAttribute("admin", newStaff);
    return newStaff;
  }

  @PutMapping("/api/adminStaff/update/{username}")
  public AdminStaff updateAdminStaff(
          HttpSession session,
          @RequestBody AdminStaff adminStaff,
          @PathVariable("username") String username) {
    AdminStaff prevAdmin = hospitalDao.findAdminStaffByUsername(username);
    prevAdmin.setFirstName(adminStaff.getFirstName());
    prevAdmin.setLastName(adminStaff.getLastName());
    prevAdmin.setDateOfBirth(adminStaff.getDateOfBirth());
    prevAdmin.setGender(adminStaff.getGender());
    prevAdmin.setStatus(adminStaff.getStatus());
    prevAdmin.setDepartment(adminStaff.getDepartment());
    prevAdmin.setJoiningDate(adminStaff.getJoiningDate());
    prevAdmin.setJobTitle(adminStaff.getJobTitle());
    prevAdmin.setJobDescription(adminStaff.getJobDescription());
    session.setAttribute("updatedAdminStaff", adminStaff);
    return hospitalDao.createAdminStaff(prevAdmin);
  }


  @PostMapping("api/staff/salary/create/{username}")
  public Salary createSalaryForStaff(
      @PathVariable("username") String username, @RequestBody Salary salary) {
    Staff staff = hospitalDao.findStaffByUsername(username);
    if (hospitalDao.findSalaryByStaff(staff) == null) {
      return hospitalDao.AssignSalaryForStaff(hospitalDao.findStaffByUsername(username), salary);
    } else return null;
  }

  @PutMapping("api/staff/salary/update/{username}")
  public Salary updateSalaryForStaff(
          @PathVariable("username") String username, @RequestBody Salary salary) {
    Staff staff = hospitalDao.findStaffByUsername(username);
    Salary prevSalary = hospitalDao.findSalaryByStaff(staff);
    prevSalary.setBaseSalary(salary.getBaseSalary());
    prevSalary.setAllowances(salary.getAllowances());
    prevSalary.setEpf(salary.getEpf());
    return hospitalDao.AssignSalaryForStaff(hospitalDao.findStaffByUsername(username), prevSalary);

  }

  @DeleteMapping("/api/doctor/delete/{doctorId}")
  public void deleteDoctor(@PathVariable("doctorId") String doctorId) {
    hospitalDao.deleteDoctor(doctorId);
  }

  @DeleteMapping("/api/patient/delete/{patientId}")
  public void deletePatient(@PathVariable("patientId") String patientId) {
    hospitalDao.deletePatient(patientId);
  }


}
