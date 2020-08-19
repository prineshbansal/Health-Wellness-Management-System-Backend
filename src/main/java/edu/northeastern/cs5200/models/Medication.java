package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JsonIgnore
  private Prescription prescription;

  private String medicineName;
  private int quantity;
  private float price;
  private String dosage;

  public Medication() {

  }

  public Medication(String medicineName, int quantity, float price, String dosage) {
    this.medicineName = medicineName;
    this.quantity = quantity;
    this.price = price;
    this.dosage = dosage;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Prescription getPrescription() {
    return prescription;
  }

  public void setPrescription(Prescription prescription) {
    this.prescription = prescription;
  }

  public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }
}
