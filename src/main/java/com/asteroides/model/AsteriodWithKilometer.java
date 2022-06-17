package com.asteroides.model;

public class AsteriodWithKilometer {
  private String id;
  private double averageDiameter;

  public AsteriodWithKilometer() {}

  public AsteriodWithKilometer(String id, double averageDiameter) {
    this.id = id;
    this.averageDiameter = averageDiameter;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getAverageDiameter() {
    return averageDiameter;
  }

  public void setAverageDiameter(double averageDiameter) {
    this.averageDiameter = averageDiameter;
  }
}
