package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Appointment;
import edu.northeastern.cs5200.models.Doctor;
import edu.northeastern.cs5200.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
  @Query("SELECT appointment FROM Appointment appointment WHERE appointment.id=:id")
  Appointment findAppointmentById(@Param("id") Integer id);

  @Query(
      "SELECT appointment FROM Appointment appointment WHERE appointment.doctor=:doctor AND appointment.dateOfAppointment=:date")
  List<Appointment> findAppointmentByDoctorDate(@Param("doctor") Doctor doctor, @Param("date") LocalDate date);

  @Query(
          "SELECT appointment FROM Appointment appointment WHERE appointment.doctor=:doctor AND appointment.patient=:patient")
  List<Appointment> findAppointmentByDoctorPatient(@Param("doctor") Doctor doctor, @Param("patient") Patient patient);

}
