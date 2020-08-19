package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class JpaHospitalDao implements HospitalDao {

  @Autowired private PersonRepository personRepository;

  @Autowired private PatientRepository patientRepository;

  @Autowired private DoctorRepository doctorRepository;

  @Autowired private AllergyRepository allergyRepository;

  @Autowired private InsuranceRepository insuranceRepository;

  @Autowired private PrescriptionRepository prescriptionRepository;

  @Autowired private PhoneRepository phoneRepository;

  @Autowired private SalaryRepository salaryRepository;

  @Autowired private StaffRepository staffRepository;

  @Autowired private MedicationRepository medicationRepository;

  @Autowired private AddressRepository addressRepository;

  @Autowired private AdminStaffRepository adminStaffRepository;

  @Autowired private MedicalTestRepository medicalTestRepository;

  @Autowired private AppointmentRepository appointmentRepository;

  @Override
  public List<Patient> findAllPatients() {
    return (List<Patient>) patientRepository.findAll();
  }

  @Override
  public List<Allergy> findAllAllergies() {
    return (List<Allergy>) allergyRepository.findAll();
  }

  @Override
  public List<Insurance> findAllInsurances() {
    return (List<Insurance>) insuranceRepository.findAll();
  }

  @Override
  public Patient createPatient(Patient patient) {
    return patientRepository.save(patient);
  }

  @Override
  public Patient findPatientByUsername(String username) {
    return patientRepository.findPatientByUsername(username);
  }

  @Override
  public Allergy addAllergyForPatient(Allergy allergy, Patient patient) {
    allergy.setPatient(patient);
    if (!patient.getAllergies().contains(allergy)) {
      patient.getAllergies().add(allergy);
    }
    return allergyRepository.save(allergy);
  }

  @Override
  public Insurance addInsuranceForPatient(Insurance insurance, Patient patient) {
    insurance.setPatient(patient);
    if (!patient.getInsurances().contains(insurance)) {
      patient.getInsurances().add(insurance);
    }
    return insuranceRepository.save(insurance);
  }

  @Override
  public List<Patient> findPatientsByAllergy(Allergy allergy) {
    List<Patient> patients = (List<Patient>) patientRepository.findAll();
    List<Patient> result = new ArrayList<>();

    for (Patient patient : patients) {
      if (patient.getAllergies().contains(allergy)) {
        result.add(patient);
      }
    }

    return result;
  }

  @Override
  public List<Patient> findPatientByInsurance(Insurance insurance) {
    List<Patient> patients = (List<Patient>) patientRepository.findAll();
    List<Patient> result = new ArrayList<>();

    for (Patient patient : patients) {
      if (patient.getInsurances().contains(insurance)) {
        result.add(patient);
      }
    }

    return result;
  }

  @Override
  public List<Allergy> findAllergyByPatient(Patient patient) {
    return new ArrayList<>(patient.getAllergies());
  }

  @Override
  public List<Insurance> findInsuranceByPatient(Patient patient) {
    return new ArrayList<>(patient.getInsurances());
  }

  @Override
  public void deletePatient(String username) {
    patientRepository.delete(patientRepository.findPatientByUsername(username));
  }

  @Override
  public Allergy updateAllergy(int id, Allergy updatedAllergy) {
    Allergy oldAllergy = allergyRepository.findAllergyById(id);
    oldAllergy.setAllergyInfo(updatedAllergy.getAllergyInfo());
    oldAllergy.setAllergyCause(updatedAllergy.getAllergyCause());
    return allergyRepository.save(oldAllergy);
  }

  @Override
  public void deleteAllergy(int id) {
    allergyRepository.delete(allergyRepository.findAllergyById(id));
  }

  @Override
  public Insurance updateInsurance(int id, Insurance updatedInsurance) {
    Insurance oldInsurance = insuranceRepository.findInsuranceById(id);
    oldInsurance.setInsuranceDetails(updatedInsurance.getInsuranceDetails());
    oldInsurance.setInsuranceType(updatedInsurance.getInsuranceType());
    return insuranceRepository.save(oldInsurance);
  }

  @Override
  public void deleteInsurance(int id) {
    insuranceRepository.delete(insuranceRepository.findInsuranceById(id));
  }

  @Override
  public List<Person> findAllPersons() {
    return (List<Person>) personRepository.findAll();
  }

  @Override
  public Person findPersonByUsername(String username) {
    return personRepository.findPersonByUsername(username);
  }

  @Override
  public List<Phone> findAllPhones() {
    return (List<Phone>) phoneRepository.findAll();
  }

  @Override
  public List<Address> findAllAddresses() {
    return (List<Address>) addressRepository.findAll();
  }

  @Override
  public List<Phone> findPhonesForPerson(Person person) {
    return new ArrayList<>(person.getPhones());
  }

  @Override
  public List<Address> findAddressForPerson(Person person) {
    return new ArrayList<>(person.getAddresses());
  }

  @Override
  public Phone addPhoneForPerson(Phone phone, Person person) {
    phone.setPerson(person);
    if (!person.getPhones().contains(phone)) {
      person.getPhones().add(phone);
    }
    return phoneRepository.save(phone);
  }

  @Override
  public Address addAddressForPerson(Address address, Person person) {
    address.setPerson(person);
    if (!person.getAddresses().contains(address)) {
      person.getAddresses().add(address);
    }
    return addressRepository.save(address);
  }

  @Override
  public Phone findPhoneByNumber(String phone) {
    return phoneRepository.findPhoneByNumber(phone);
  }

  @Override
  public Phone updatePhone(int id, Phone updatedPhone) {
    Phone oldPhone = phoneRepository.findPhoneById(id);
    oldPhone.setPhone(updatedPhone.getPhone());
    oldPhone.setPrimary(updatedPhone.getPrimary());
    return phoneRepository.save(oldPhone);
  }

  @Override
  public void deletePhone(int id) {
    phoneRepository.delete(phoneRepository.findPhoneById(id));
  }

  @Override
  public Address updateAddress(int id, Address updatedAddress) {
    Address oldAddress = addressRepository.findAddressById(id);
    oldAddress.setHouse(updatedAddress.getHouse());
    oldAddress.setStreet1(updatedAddress.getStreet1());
    oldAddress.setStreet2(updatedAddress.getStreet2());
    oldAddress.setCity(updatedAddress.getCity());
    oldAddress.setState(updatedAddress.getState());
    oldAddress.setZip(updatedAddress.getZip());
    return addressRepository.save(oldAddress);
  }

  @Override
  public void deleteAddress(int id) {
    addressRepository.delete(addressRepository.findAddressById(id));
  }

  @Override
  public List<Salary> findAllSalary() {
    return (List<Salary>) salaryRepository.findAll();
  }

  @Override
  public Salary findSalaryByStaff(Staff staff) {
    return staff.getSalary();
  }

  @Override
  public Salary createSalary(Salary sal) {
    return salaryRepository.save(sal);
  }

  @Override
  public Salary AssignSalaryForStaff(Staff staff, Salary salary) {
    staff.setSalary(salary);
    salary.setStaff(staff);
    return salaryRepository.save(salary);
  }

  @Override
  public List<Staff> findAllStaff() {
    return (List<Staff>) staffRepository.findAll();
  }

  @Override
  public List<Medication> findAllMedication() {
    return (List<Medication>) medicationRepository.findAll();
  }

  @Override
  public List<MedicalTest> findAllTests() {
    return (List<MedicalTest>) medicalTestRepository.findAll();
  }

  @Override
  public List<Medication> findMedicationByPrescription(Prescription prescription) {
    return (List<Medication>) prescription.getMedications();
  }

  @Override
  public void deleteMedication(int id) {
    medicationRepository.delete(medicationRepository.findMedicationById(id));
  }

  @Override
  public void deleteMedicalTest(int id) {
    medicalTestRepository.delete(medicalTestRepository.findTestById(id));
  }

  @Override
  public List<Prescription> findAllPrescriptions() {
    return (List<Prescription>) prescriptionRepository.findAll();
  }

  @Override
  public List<Prescription> findPrescriptionsByDoctor(Doctor doctor) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getDoctor().getId().equals(doctor.getId())) {
        result.add(prescription);
      }
    }

    return result;
  }

  @Override
  public List<Prescription> findPrescriptionsByPatient(Patient patient) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getPatient().getId().equals(patient.getId())) {
        result.add(prescription);
      }
    }

    return result;
  }

  @Override
  public List<Prescription> findPrescriptionsByDoctorToPatient(Doctor doctor, Patient patient) {
    List<Prescription> prescriptions = (List<Prescription>) prescriptionRepository.findAll();
    List<Prescription> result = new ArrayList<>();

    for (Prescription prescription : prescriptions) {
      if (prescription.getPatient().getId().equals(patient.getId())) {
        if (prescription.getDoctor().getId().equals(doctor.getId())) {
          result.add(prescription);
        }
      }
    }

    return result;
  }

  @Override
  public Prescription findPrescriptionByDoctorToPatientOnDate(
      Doctor doctor, Patient patient, String date) {
    LocalDate presDate = LocalDate.parse(date);
    return prescriptionRepository.findPrescriptionByDoctorAndPatientAndDate(
        doctor, patient, presDate);
  }

  @Override
  public Medication addMedicationToPrescription(Prescription prescription, Medication medication) {
    medication.setPrescription(prescription);
    if (!prescription.getMedications().contains(medication)) {
      prescription.getMedications().add(medication);
    }
    return medicationRepository.save(medication);
  }

  @Override
  public MedicalTest addMedicalTestToPrescription(
      Prescription prescription, MedicalTest medicalTest) {
    medicalTest.setPrescription(prescription);
    if (!prescription.getMedicalTests().contains(medicalTest)) {
      prescription.getMedicalTests().add(medicalTest);
    }
    return medicalTestRepository.save(medicalTest);
  }

  @Override
  public Prescription assignPrescription(
      Doctor doctor, Patient patient, Prescription prescription) {
    if (prescriptionRepository.findPrescriptionByDoctorAndPatientAndDate(
            doctor, patient, prescription.getPrescriptionDate())
        == null) {
      prescription.setDoctor(doctor);
      prescription.setPatient(patient);
      patient.getPrescriptions().add(prescription);
      doctor.getPrescriptions().add(prescription);
      return prescriptionRepository.save(prescription);
    }
    return null;
  }

  @Override
  public void deletePrescription(int id) {
    prescriptionRepository.delete(prescriptionRepository.findPrescriptionById(id));
  }

  @Override
  public List<Appointment> findAllAppointments() {
    return (List<Appointment>) appointmentRepository.findAll();
  }

  @Override
  public Appointment createAppointments(Doctor doctor, Patient patient, Appointment appointment) {

    appointment.setDoctor(doctor);
    appointment.setPatient(patient);

    if (!patient.getAppointments().contains(appointment)) {
      patient.getAppointments().add(appointment);
    }
    if (!doctor.getAppointments().contains(appointment)) {
      doctor.getAppointments().add(appointment);
    }
    return appointmentRepository.save(appointment);
  }

  @Override
  public List<Appointment> findAppointmentByDoctor(String username) {
    return new ArrayList<>(doctorRepository.findDoctorByUsername(username).getAppointments());
  }

  @Override
  public List<Appointment> findAppointmentByPatient(String username) {
    return new ArrayList<>(patientRepository.findPatientByUsername(username).getAppointments());
  }

  @Override
  public List<Appointment> findAppointmentByDoctorOnDate(Doctor doctor, LocalDate date) {
    return appointmentRepository.findAppointmentByDoctorDate(doctor, date);
  }

  @Override
  public List<Appointment> findAppointmentByDoctorToPatient(Doctor doctor, Patient patient) {
    return appointmentRepository.findAppointmentByDoctorPatient(doctor, patient);
  }

  @Override
  public Appointment updateAppointment(int id, Appointment updatedAppointment) {
    Appointment oldAppointment = appointmentRepository.findAppointmentById(id);
    oldAppointment.setTime(updatedAppointment.getTime());
    oldAppointment.setNotes(updatedAppointment.getNotes());
    oldAppointment.setDateOfAppointment(updatedAppointment.getDateOfAppointment());
    return appointmentRepository.save(oldAppointment);
  }

  @Override
  public void deleteAppointment(int id) {
    appointmentRepository.delete(appointmentRepository.findAppointmentById(id));
  }

  @Override
  public Doctor createDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public List<Doctor> findAllDoctors() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  @Override
  public Doctor findDoctorByUsername(String username) {
    return doctorRepository.findDoctorByUsername(username);
  }

  @Override
  public void deleteDoctor(String username) {
    doctorRepository.delete(doctorRepository.findDoctorByUsername(username));
  }

  @Override
  public AdminStaff createAdminStaff(AdminStaff adminStaff) {
    return adminStaffRepository.save(adminStaff);
  }

  @Override
  public List<AdminStaff> findAllAdminStaffs() {
    return (List<AdminStaff>) adminStaffRepository.findAll();
  }

  @Override
  public AdminStaff findAdminStaffByUsername(String username) {
    return adminStaffRepository.findAdminStaffByUsername(username);
  }

  @Override
  public void deleteAdminStaff(String username) {
    adminStaffRepository.delete(adminStaffRepository.findAdminStaffByUsername(username));
  }

  @Override
  public Staff findStaffByUsername(String username) {
    return staffRepository.findStaffByUsername(username);
  }
}
