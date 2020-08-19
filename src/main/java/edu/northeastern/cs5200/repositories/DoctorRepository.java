package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
  @Query("SELECT doctor FROM Doctor doctor WHERE doctor.username=:username")
  Doctor findDoctorByUsername(@Param("username") String username);
}
