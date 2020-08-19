package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query("SELECT patient FROM Patient patient WHERE patient.username=:username")
    Patient findPatientByUsername(@Param("username") String username);
}
