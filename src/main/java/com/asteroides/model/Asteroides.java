package com.asteroides.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class Asteroides {

  @JsonProperty("near_earth_objects")
  private Map<String, List<AsteroidsInformation>> nearEarthObjects;

  public Map<String, List<AsteroidsInformation>> getNearEarthObjects() {
    return nearEarthObjects;
  }

  public void setNearEarthObjects(Map<String, List<AsteroidsInformation>> nearEarthObjects) {
    this.nearEarthObjects = nearEarthObjects;
  }
}
