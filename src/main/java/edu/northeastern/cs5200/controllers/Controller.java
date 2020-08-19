package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class Controller {

  @Autowired private HospitalDao hospitalDao;

  /** Find Alls */
  @GetMapping("api/persons/find/all")
  public List<Person> findAllPersons() {
    return (List<Person>) hospitalDao.findAllPersons();
  }

  @GetMapping("api/patients/find/all")
  public List<Patient> findAllPatients() {
    return (List<Patient>) hospitalDao.findAllPatients();
  }

  @GetMapping("api/doctors/find/all")
  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) hospitalDao.findAllDoctors();
  }

  @GetMapping("api/prescriptions/find/all")
  public List<Prescription> findAllPrescriptions() {
    return (List<Prescription>) hospitalDao.findAllPrescriptions();
  }

  @GetMapping("api/allergies/find/all")
  public List<Allergy> findAllAllergies() {
    return (List<Allergy>) hospitalDao.findAllAllergies();
  }

  @GetMapping("api/insurances/find/all")
  public List<Insurance> findAllInsurances() {
    return (List<Insurance>) hospitalDao.findAllInsurances();
  }

  @GetMapping("api/phones/find/all")
  public List<Phone> findAllPhones() {
    return (List<Phone>) hospitalDao.findAllPhones();
  }

  @GetMapping("api/addresses/find/all")
  public List<Address> findAllAddresses() {
    return (List<Address>) hospitalDao.findAllAddresses();
  }

  @GetMapping("api/salary/find/all")
  public List<Salary> findAllSalary() {
    return (List<Salary>) hospitalDao.findAllSalary();
  }

  @GetMapping("api/staff/find/all")
  public List<Staff> findAllStaff() {
    return (List<Staff>) hospitalDao.findAllStaff();
  }

  @GetMapping("api/medication/find/all")
  List<Medication> findAllMedication() {
    return (List<Medication>) hospitalDao.findAllMedication();
  }

  @GetMapping("api/tests/find/all")
  List<MedicalTest> findAllTests() {
    return (List<MedicalTest>) hospitalDao.findAllTests();
  }

  @GetMapping("api/appointments/find/all")
  List<Appointment> findAllAppointments() {
    return (List<Appointment>) hospitalDao.findAllAppointments();
  }

  @GetMapping("api/adminstaff/find/all")
  List<AdminStaff> findAllAdminStaffs() {
    return (List<AdminStaff>) hospitalDao.findAllAdminStaffs();
  }

  /** Find by username */
  @RequestMapping("api/persons/find/username/{username}")
  public Person findPersonByUsername(@PathVariable("username") String username) {
    return hospitalDao.findPersonByUsername(username);
  }

  @RequestMapping("api/patients/find/username/{username}")
  public Patient findPatientByUsername(@PathVariable("username") String username) {
    return hospitalDao.findPatientByUsername(username);
  }

  @RequestMapping("api/doctors/find/username/{username}")
  public Doctor findDoctorByUsername(@PathVariable("username") String username) {
    return hospitalDao.findDoctorByUsername(username);
  }

  @RequestMapping("api/adminstaff/find/username/{username}")
  public AdminStaff findAdminStaffByUsername(@PathVariable("username") String username) {
    return hospitalDao.findAdminStaffByUsername(username);
  }

  /** Class specific methods. (One to Many) */
  @RequestMapping("api/allergies/find/patient/{username}")
  public List<Allergy> findAllergyByPatient(@PathVariable("username") String username) {
    return (List<Allergy>)
        hospitalDao.findAllergyByPatient(hospitalDao.findPatientByUsername(username));
  }

  @RequestMapping("api/insurances/find/patient/{username}")
  public List<Insurance> findInsuranceByPatient(@PathVariable("username") String username) {
    return (List<Insurance>)
        hospitalDao.findInsuranceByPatient(hospitalDao.findPatientByUsername(username));
  }

  @RequestMapping("api/phones/find/persons/{username}")
  public List<Phone> findPhonesForPerson(@PathVariable("username") String username) {
    return (List<Phone>)
        hospitalDao.findPhonesForPerson(hospitalDao.findPersonByUsername(username));
  }

  @RequestMapping("api/address/find/persons/{username}")
  public List<Address> findAddressForPerson(@PathVariable("username") String username) {
    return (List<Address>)
        hospitalDao.findAddressForPerson(hospitalDao.findPersonByUsername(username));
  }

  @RequestMapping("api/salary/find/staff/{username}")
  public Salary findSalaryByStaff(@PathVariable("username") String username) {
    return hospitalDao.findSalaryByStaff(hospitalDao.findStaffByUsername(username));
  }

  /** Class specific Many to Many */
  @RequestMapping("api/prescription/find/doctor/{username}")
  public List<Prescription> findPrescriptionsByDoctor(@PathVariable("username") String username) {
    return hospitalDao.findPrescriptionsByDoctor(hospitalDao.findDoctorByUsername(username));
  }

  @RequestMapping("api/prescription/find/patient/{username}")
  public List<Prescription> findPrescriptionsByPatient(@PathVariable("username") String username) {
    return hospitalDao.findPrescriptionsByPatient(hospitalDao.findPatientByUsername(username));
  }

  @RequestMapping("api/prescription/find/doctor-patient/{docusername}/{patusername}")
  public List<Prescription> findPrescriptionsByDoctorToPatient(
      @PathVariable("docusername") String docusername,
      @PathVariable("patusername") String patusername) {
    return hospitalDao.findPrescriptionsByDoctorToPatient(
        hospitalDao.findDoctorByUsername(docusername),
        hospitalDao.findPatientByUsername(patusername));
  }

  @RequestMapping("api/appointment/find/doctor/{username}")
  public List<Appointment> findAppointmentByDoctor(@PathVariable("username") String username) {
    return hospitalDao.findAppointmentByDoctor(username);
  }

  @RequestMapping("api/appointment/find/patient/{username}")
  public List<Appointment> findAppointmentByPatient(@PathVariable("username") String username) {
    return hospitalDao.findAppointmentByPatient(username);
  }
}
