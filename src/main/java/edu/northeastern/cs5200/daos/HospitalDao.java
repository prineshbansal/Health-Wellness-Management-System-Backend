package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.*;

import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;


@Service
public interface HospitalDao {
  // Patient related Methods
  List<Patient> findAllPatients();

  List<Allergy> findAllAllergies();

  List<Insurance> findAllInsurances();

  Patient createPatient(Patient patient);

  Patient findPatientByUsername(String username);

  Allergy addAllergyForPatient(Allergy allergy, Patient patient);

  Insurance addInsuranceForPatient(Insurance insurance, Patient patient);

  List<Patient> findPatientsByAllergy(Allergy allergy);

  List<Patient> findPatientByInsurance(Insurance insurance);

  List<Allergy> findAllergyByPatient(Patient patient);

  List<Insurance> findInsuranceByPatient(Patient patient);

  void deletePatient(String username);

  Allergy updateAllergy(int id, Allergy updatedAllergy);

  void deleteAllergy(int id);

  Insurance updateInsurance(int id, Insurance updatedInsurance);

  void deleteInsurance(int id);

  // Person Methods
  List<Person> findAllPersons();

  Person findPersonByUsername(String username);

  //Phone & Address Methods
  List<Phone> findAllPhones();

  List<Address> findAllAddresses();

  List<Phone> findPhonesForPerson(Person person);

  List<Address> findAddressForPerson(Person person);

  Phone addPhoneForPerson(Phone phone, Person person);

  Address addAddressForPerson(Address address, Person person);

  Phone findPhoneByNumber(String phone);

  Phone updatePhone(int id, Phone updatedPhone);

  void deletePhone(int id);

  Address updateAddress(int id, Address updatedAddress);

  void deleteAddress(int id);

  //Salary Methods
  List<Salary> findAllSalary();

  Salary findSalaryByStaff(Staff staff);

  Salary createSalary(Salary sal);

  Salary AssignSalaryForStaff(Staff staff, Salary salary);

  //Staff Methods
  List<Staff> findAllStaff();

  Staff findStaffByUsername(String username);

  //Medication & Medical Tests Methods
  List<Medication> findAllMedication();

  List<MedicalTest> findAllTests();

  List<Medication> findMedicationByPrescription(Prescription prescription);

  void deleteMedication(int id);

  void deleteMedicalTest(int id);

  // Prescription Methods
  List<Prescription> findAllPrescriptions();

  List<Prescription> findPrescriptionsByDoctor(Doctor doctor);

  List<Prescription> findPrescriptionsByPatient(Patient patient);

  List<Prescription> findPrescriptionsByDoctorToPatient(Doctor doctor, Patient patient);

  Prescription findPrescriptionByDoctorToPatientOnDate(Doctor doctor, Patient patient, String date);

  Medication addMedicationToPrescription(Prescription prescription, Medication medication);

  MedicalTest addMedicalTestToPrescription(Prescription prescription, MedicalTest medicalTest);

  Prescription assignPrescription(Doctor doctor, Patient patient, Prescription prescription);

  void deletePrescription(int id);

  // Appointment Methods
  Appointment createAppointments(Doctor doctor, Patient patient, Appointment appointment);

  List<Appointment> findAllAppointments();

  List<Appointment> findAppointmentByDoctor(String username);

  List<Appointment> findAppointmentByPatient(String username);

  List<Appointment> findAppointmentByDoctorOnDate(Doctor doctor, LocalDate date);

  List<Appointment> findAppointmentByDoctorToPatient(Doctor doctor, Patient patient);

  Appointment updateAppointment(int id, Appointment updatedAppointment);

  void deleteAppointment(int id);

  //Doctor Methods
  Doctor createDoctor(Doctor doctor);

  List<Doctor> findAllDoctors();

  Doctor findDoctorByUsername(String username);

  void deleteDoctor(String username);

  // Admin Staff Methods
  AdminStaff createAdminStaff(AdminStaff adminStaff);

  List<AdminStaff> findAllAdminStaffs();

  AdminStaff findAdminStaffByUsername(String username);

  void deleteAdminStaff(String username);
}
