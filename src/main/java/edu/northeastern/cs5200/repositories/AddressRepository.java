package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
  @Query("SELECT address FROM Address address WHERE address.id=:id")
  Address findAddressById(@Param("id") Integer id);
}
