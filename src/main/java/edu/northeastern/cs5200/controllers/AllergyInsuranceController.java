package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.daos.HospitalDao;
import edu.northeastern.cs5200.models.Allergy;
import edu.northeastern.cs5200.models.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class AllergyInsuranceController {
  @Autowired HospitalDao hospitalDao;

  @PostMapping("/api/patient/allergy/create/{username}")
  public Allergy createAllergy(
      HttpSession session,
      @PathVariable("username") String username,
      @RequestBody Allergy allergy) {
    Allergy newAllergy =
        hospitalDao.addAllergyForPatient(allergy, hospitalDao.findPatientByUsername(username));

    return newAllergy;
  }

  @PostMapping("/api/patient/insurance/create/{username}")
  public Insurance createInsurance(
      HttpSession session,
      @PathVariable("username") String username,
      @RequestBody Insurance insurance) {
    Insurance newInsurance =
        hospitalDao.addInsuranceForPatient(insurance, hospitalDao.findPatientByUsername(username));

    return newInsurance;
  }

  @PutMapping("/api/patient/update/allergy/{allergyId}")
  public Allergy updateAllergy(
          HttpSession session,
          @RequestBody Allergy updatedAllergy,
          @PathVariable("allergyId") String allergyId) {
    return hospitalDao.updateAllergy(Integer.parseInt(allergyId), updatedAllergy);
  }

  @PutMapping("/api/patient/update/insurance/{insuranceId}")
  public Insurance updateInsurance(
          HttpSession session,
          @RequestBody Insurance updatedInsurance,
          @PathVariable("insuranceId") String insuranceId) {
    return hospitalDao.updateInsurance(Integer.parseInt(insuranceId), updatedInsurance);
  }

  @DeleteMapping("/api/patient/delete/allergy/{allergyId}")
  public void deleteAllergy(@PathVariable("allergyId") String allergyId) {
    hospitalDao.deleteAllergy(Integer.parseInt(allergyId));
  }

  @DeleteMapping("/api/patient/delete/insurance/{insuranceId}")
  public void deleteInsurance(@PathVariable("insuranceId") String insuranceId) {
    hospitalDao.deleteInsurance(Integer.parseInt(insuranceId));
  }

}
