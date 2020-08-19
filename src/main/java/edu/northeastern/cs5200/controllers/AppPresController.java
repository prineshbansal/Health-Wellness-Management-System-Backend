package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class AppPresController {

  @Autowired UserRepository userRepository;

  @Autowired HospitalDao hospitalDao;

  @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/appointment")
  public Appointment createAppointment(
      HttpSession session,
      @PathVariable("docUsername") String docUsername,
      @PathVariable("patUsername") String patUsername,
      @RequestBody Appointment appointment) {
    Appointment newAppointment =
        hospitalDao.createAppointments(
            hospitalDao.findDoctorByUsername(docUsername),
            hospitalDao.findPatientByUsername(patUsername),
            appointment);
    return newAppointment;
  }

  @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/prescription")
  public Prescription createPrescription(
      HttpSession session,
      @PathVariable("docUsername") String docUsername,
      @PathVariable("patUsername") String patUsername,
      @RequestBody Prescription prescription) {
    Prescription newPrescription =
        hospitalDao.assignPrescription(
            hospitalDao.findDoctorByUsername(docUsername),
            hospitalDao.findPatientByUsername(patUsername),
            prescription);
    return newPrescription;
  }

  @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/date/{presDate}/medication")
  public Medication createMedication(
      HttpSession session,
      @PathVariable("docUsername") String docUsername,
      @PathVariable("patUsername") String patUsername,
      @PathVariable("presDate") String presDate,
      @RequestBody Medication medication) {

    Doctor doctor = hospitalDao.findDoctorByUsername(docUsername);
    Patient patient = hospitalDao.findPatientByUsername(patUsername);
    Medication newMedication =
        hospitalDao.addMedicationToPrescription(
            hospitalDao.findPrescriptionByDoctorToPatientOnDate(doctor, patient, presDate),
            medication);
    return newMedication;
  }

  @PostMapping("/api/doctor/{docUsername}/patient/{patUsername}/date/{presDate}/medicalTest")
  public MedicalTest createMedicalTest(
      HttpSession session,
      @PathVariable("docUsername") String docUsername,
      @PathVariable("patUsername") String patUsername,
      @PathVariable("presDate") String presDate,
      @RequestBody MedicalTest medicalTest) {

    Doctor doctor = hospitalDao.findDoctorByUsername(docUsername);
    Patient patient = hospitalDao.findPatientByUsername(patUsername);
    MedicalTest newMedicalTest =
        hospitalDao.addMedicalTestToPrescription(
            hospitalDao.findPrescriptionByDoctorToPatientOnDate(doctor, patient, presDate),
            medicalTest);
    return newMedicalTest;
  }

  @GetMapping("/api/doctor/{docUsername}/date/{date}/appointment")
  public List<Appointment> findAppointmentByDoctorOnDate(
      HttpSession session,
      @PathVariable("docUsername") String docUsername,
      @PathVariable("date") String date) {
    return hospitalDao.findAppointmentByDoctorOnDate(
        hospitalDao.findDoctorByUsername(docUsername), LocalDate.parse(date));
  }

  @GetMapping("/api/doctor/{docUsername}/patient/{patUsername}/appointment")
  public List<Appointment> findAppointmentByDoctorToPatient(
          HttpSession session,
          @PathVariable("docUsername") String docUsername,
          @PathVariable("patUsername") String patUsername) {
    return hospitalDao.findAppointmentByDoctorToPatient(
            hospitalDao.findDoctorByUsername(docUsername),
            hospitalDao.findPatientByUsername(patUsername));
  }

  @PutMapping("/api/update/appointment/{appointmentId}")
  public Appointment updateAppointment(
      HttpSession session,
      @RequestBody Appointment updatedAppointment,
      @PathVariable("appointmentId") String appointmentId) {
    return hospitalDao.updateAppointment(Integer.parseInt(appointmentId), updatedAppointment);
  }

  @DeleteMapping("/api/prescription/delete/{prescriptionId}")
  public void deletePrescription(@PathVariable("prescriptionId") String prescriptionId) {
    hospitalDao.deletePrescription(Integer.parseInt(prescriptionId));
  }

  @DeleteMapping("/api/appointment/delete/{appointmentId}")
  public void deleteAppointment(@PathVariable("appointmentId") String appointmentId) {
    hospitalDao.deleteAppointment(Integer.parseInt(appointmentId));
  }
}
