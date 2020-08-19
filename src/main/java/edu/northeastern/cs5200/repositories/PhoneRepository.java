package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
  @Query("SELECT phone FROM Phone phone WHERE phone.phone=:phone")
  Phone findPhoneByNumber(@Param("phone") String phone);

  @Query("SELECT phone FROM Phone phone WHERE phone.id=:id")
  Phone findPhoneById(@Param("id") Integer id);
}
