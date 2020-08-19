package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Insurance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {
  @Query("SELECT insurance FROM Insurance insurance WHERE insurance.id=:id")
  Insurance findInsuranceById(@Param("id") Integer id);
}
