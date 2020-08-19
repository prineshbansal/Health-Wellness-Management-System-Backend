package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer> {}
