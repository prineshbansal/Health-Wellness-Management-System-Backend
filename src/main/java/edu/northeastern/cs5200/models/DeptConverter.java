package edu.northeastern.cs5200.models;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DeptConverter implements AttributeConverter<Department, String> {
  @Override
  public String convertToDatabaseColumn(Department department) {
    if (department == null) {
      return null;
    }
    return department.getDept();
  }

  @Override
  public Department convertToEntityAttribute(String department) {
    if (department == null) {
      return null;
    }
    return Stream.of(Department.values())
            .filter(d-> d.getDept().equals(department))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);

  }
}
