package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Medication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Integer> {
  @Query("SELECT medication FROM Medication medication WHERE medication.id=:id")
  Medication findMedicationById(@Param("id") Integer id);
}
