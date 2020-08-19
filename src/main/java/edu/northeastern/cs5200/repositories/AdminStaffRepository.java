package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.AdminStaff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaffRepository extends CrudRepository<AdminStaff, Integer> {
  @Query("SELECT AdminStaff FROM AdminStaff AdminStaff WHERE AdminStaff.username=:username")
  AdminStaff findAdminStaffByUsername(@Param("username") String username);
}
