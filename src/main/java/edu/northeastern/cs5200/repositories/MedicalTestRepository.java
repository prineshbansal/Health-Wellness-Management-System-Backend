package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.MedicalTest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalTestRepository extends CrudRepository<MedicalTest, Integer> {
  @Query("SELECT medicalTest FROM MedicalTest medicalTest WHERE medicalTest.id=:id")
  MedicalTest findTestById(@Param("id") Integer id);
}
