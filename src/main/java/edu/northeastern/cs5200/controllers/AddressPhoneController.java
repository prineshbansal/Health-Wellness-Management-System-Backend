package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class AddressPhoneController {
  @Autowired UserRepository userRepository;

  @Autowired HospitalDao hospitalDao;

  @PostMapping("/api/person/address/create/{username}")
  public Address createAddressForPatient(
      HttpSession session,
      @PathVariable("username") String username,
      @RequestBody Address address) {
    Address newAddr =
        hospitalDao.addAddressForPerson(address, hospitalDao.findPersonByUsername(username));

    return newAddr;
  }

  @PostMapping("/api/person/phone/create/{username}")
  public Phone createPhoneForPerson(
      HttpSession session, @PathVariable("username") String username, @RequestBody Phone phone) {
    Phone newPhone =
        hospitalDao.addPhoneForPerson(phone, hospitalDao.findPersonByUsername(username));
    return newPhone;
  }

  @DeleteMapping("/api/person/address/{addressId}")
  public void deleteAddress(@PathVariable("addressId") String addressId) {
    hospitalDao.deleteAddress(Integer.parseInt(addressId));
  }

  @DeleteMapping("/api/person/phone/{phoneId}")
  public void deletePhone(@PathVariable("phoneId") String phoneId) {
    hospitalDao.deletePhone(Integer.parseInt(phoneId));
  }

  @PutMapping("/api/person/update/phone/{phoneId}")
  public Phone updatePhone(
          HttpSession session,
          @RequestBody Phone updatedPhone,
          @PathVariable("phoneId") String phoneId) {
    return hospitalDao.updatePhone(Integer.parseInt(phoneId), updatedPhone);
  }

  @PutMapping("/api/person/update/address/{addressId}")
  public Address updateAddress(
          HttpSession session,
          @RequestBody Address updatedAddress,
          @PathVariable("addressId") String addressId) {
    return hospitalDao.updateAddress(Integer.parseInt(addressId), updatedAddress);
  }

}
