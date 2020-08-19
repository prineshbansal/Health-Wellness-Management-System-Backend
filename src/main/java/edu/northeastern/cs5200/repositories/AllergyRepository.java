package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Allergy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends CrudRepository<Allergy, Integer> {
  @Query("SELECT allergy FROM Allergy allergy WHERE allergy.id=:id")
  Allergy findAllergyById(@Param("id") Integer id);
}
