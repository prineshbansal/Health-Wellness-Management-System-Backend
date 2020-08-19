package edu.northeastern.cs5200.models;

public enum Department {
  ENT("ENT"), CARDIOLOGY("CRD"),
  GYNAECOLOGY("GYN"), ORTHOPAEDIC("ORT"),
  PEDIATRIC("PED");

  private String dept;

  private Department(String dept) {
    this.dept = dept;
  }

  public String getDept() {
    return dept;
  }

}
