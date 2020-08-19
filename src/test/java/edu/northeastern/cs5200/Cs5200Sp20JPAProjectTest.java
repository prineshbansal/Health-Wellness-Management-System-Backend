package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cs5200Sp20JPAProjectTest {
  @Autowired
  private HospitalDao hospitalDao;

  @Test
  public void createPatientTest() {
    Patient patient =
            new Patient(
                    "John",
                    "Jevier",
                    "j.j",
                    "pisasuave123",
                    LocalDate.parse("1997-12-12"),
                    "male",
                    "has a scar on left hand, cuts on face",
                    LocalDate.parse("2012-10-20"));

    hospitalDao.createPatient(patient);

    Phone phonePrimary = new Phone("123456789", true);
    Phone phoneSecondary = new Phone("asasa07654321", false);
    Address address1 = new Address("Apt31", "Boylston", "Street", "Boston", "MA", "02215");
    Allergy allergyOne = new Allergy("Rashes on skin", "Aloe");
    Insurance insuranceOne =
            new Insurance("Government Insurance", "Subject to government approval");
    hospitalDao.addAddressForPerson(address1, hospitalDao.findPatientByUsername("j.j"));
    hospitalDao.addAllergyForPatient(allergyOne, hospitalDao.findPatientByUsername("j.j"));
    hospitalDao.addInsuranceForPatient(insuranceOne, hospitalDao.findPatientByUsername("j.j"));
    hospitalDao.addPhoneForPerson(phonePrimary, hospitalDao.findPatientByUsername("j.j"));
    hospitalDao.addPhoneForPerson(phoneSecondary, hospitalDao.findPatientByUsername("j.j"));
  }

  @Test
  public void createDoctors() {
    Doctor doctor =
            new Doctor(
                    "John",
                    "Doe",
                    "john",
                    "john1234",
                    LocalDate.parse("1985-05-17"),
                    "Male",
                    "active",
                    Department.ENT,
                    LocalDate.parse("2002-07-01"),
                    "Surgeon",
                    "MBBS/MD",
                    "ENT - Surgeon");
    hospitalDao.createDoctor(doctor);

    Phone phonePrimary = new Phone("1234521216789", true);
    Phone phoneSecondary = new Phone("0987693354321", false);
    Address address1 = new Address("Apt21", "Boylston", "Street", "Boston", "MA", "02215");
    Salary salary = new Salary(10000, 20000, 23000);
    hospitalDao.addAddressForPerson(address1, hospitalDao.findDoctorByUsername("john"));
    hospitalDao.addPhoneForPerson(phonePrimary, hospitalDao.findDoctorByUsername("john"));
    hospitalDao.addPhoneForPerson(phoneSecondary, hospitalDao.findDoctorByUsername("john"));
    hospitalDao.AssignSalaryForStaff(hospitalDao.findDoctorByUsername("john"), salary);
  }

  @Test
  public void createAdminStaff() {
    AdminStaff member1 =
            new AdminStaff(
                    "steve",
                    "shreedhar",
                    "steve",
                    "missy1234",
                    LocalDate.parse("1990-11-17"), // dob
                    "Female",
                    "active",
                    Department.GYNAECOLOGY,
                    LocalDate.parse("2015-05-01"), // joining date
                    "Nurse",
                    "Take care casualty cases");

    Phone phonePrimary = new Phone("1239", true);
    Phone phoneSecondary = new Phone("09821", false);
    Address add1 = new Address("Apt231", "lexington", "Street", "newYork", "NY", "02215");
    Salary salary = new Salary(10000, 20000, 23000);

    hospitalDao.createAdminStaff(member1);
    hospitalDao.addAddressForPerson(add1, hospitalDao.findAdminStaffByUsername("steve"));
    hospitalDao.addPhoneForPerson(phonePrimary, hospitalDao.findAdminStaffByUsername("steve"));
    hospitalDao.addPhoneForPerson(phoneSecondary, hospitalDao.findAdminStaffByUsername("steve"));
    hospitalDao.AssignSalaryForStaff(hospitalDao.findAdminStaffByUsername("steve"), salary);
  }

  @Test
  public void createAppointment() {
    Doctor doctor = hospitalDao.findDoctorByUsername("john");
    Patient patient = hospitalDao.findPatientByUsername("j.j");
    Appointment appointment =
            new Appointment("General Checkup", "18.00", LocalDate.parse("2020-12-12"));

    hospitalDao.createAppointments(doctor, patient, appointment);
  }

  @Test
  public void createPrescriptions() {
    Doctor doctor = hospitalDao.findDoctorByUsername("john");
    Patient patient = hospitalDao.findPatientByUsername("j.j");
    Prescription prescription = new Prescription(LocalDate.parse("2020-02-18"),
            "This medicines have to be refilled every week",
            false);

    hospitalDao.assignPrescription(doctor, patient, prescription);
  }

  @Test
  public void addMedicationToPrescription() {
    Doctor doctor = hospitalDao.findDoctorByUsername("john");
    Patient patient = hospitalDao.findPatientByUsername("j.j");
    Medication medication = new Medication("Azhithromycin Tablets", 2, 12.16f, "1--0--1");

    hospitalDao.addMedicationToPrescription(
            hospitalDao.findPrescriptionByDoctorToPatientOnDate(doctor, patient, "2020-11-18"),
            medication);
  }

  @Test
  public void addMedicalTestToPrescription() {
    Doctor doctor = hospitalDao.findDoctorByUsername("john");
    Patient patient = hospitalDao.findPatientByUsername("j.j");

    MedicalTest medicalTest =
            new MedicalTest("X-Ray", "No Bones Broken", LocalDate.parse("2020-11-18"));
    hospitalDao.addMedicalTestToPrescription(
            hospitalDao.findPrescriptionByDoctorToPatientOnDate(doctor, patient, "2020-11-18"),
            medicalTest);
  }

  @Test
  public void deletePatientTest() {
    hospitalDao.deletePatient("j.j");
  }

  @Test
  public void deleteDoctorTest() {
    hospitalDao.deleteDoctor("john");
  }

  @Test
  public void deleteAdminStaffTest() {
    hospitalDao.deleteAdminStaff("steve");
  }

  @Test
  public void deletePhoneTest() {
    hospitalDao.deletePhone(12);
  }

  @Test
  public void deleteAddressTest() {
    hospitalDao.deleteAddress(5);
  }

  @Test
  public void deleteAllergyTest() {
    hospitalDao.deleteAllergy(2);
  }

  @Test
  public void deleteInsuranceTest() {
    hospitalDao.deleteInsurance(2);
  }

  @Test
  public void deleteAppointmentTest() {
    hospitalDao.deleteAppointment(1);
  }

  @Test
  public void deleteMedicationTest() {
    hospitalDao.deleteMedication(1);
  }

  @Test
  public void deleteMedicalTestsTest() {
    hospitalDao.deleteMedicalTest(1);
  }

  @Test
  public void deletePrescriptionTest() {
    hospitalDao.deletePrescription(2);
  }

  @Test
  public void updateAllergyTest() {
    Allergy newAllergy = new Allergy();
    newAllergy.setAllergyCause("Coconut");
    newAllergy.setAllergyInfo("Near Death");
    hospitalDao.updateAllergy(3, newAllergy);
  }

  @Test
  public void updatePhoneTest() {
    Phone newPhone = new Phone();
    newPhone.setPrimary(false);
    newPhone.setPhone("98345173112");
    hospitalDao.updatePhone(2, newPhone);
  }

  @Test
  public void updateAddressTest() {
    Address newAddress = new Address(
            "Apt720",
            "Hanuman",
            "Nagar",
            "Boston",
            "MA",
            "02215"
    );
    hospitalDao.updateAddress(14, newAddress);
  }

  @Test
  public void updateInsuranceTest() {
    Insurance newInsurance = new Insurance();
    newInsurance.setInsuranceType("Seedha death");
    newInsurance.setInsuranceDetails("mein tereko bola na, ghanta kuch nahi milega");
    hospitalDao.updateInsurance(3, newInsurance);
  }

  @Test
  public void updateAppointment() {
    Appointment newAppointment =
            new Appointment("Eye Check Up", "18.30", LocalDate.parse("2020-09-09"));
    hospitalDao.updateAppointment(1,newAppointment);
  }
}
