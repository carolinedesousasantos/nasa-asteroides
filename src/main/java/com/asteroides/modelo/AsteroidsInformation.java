package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AsteroidsInformation {

  private String id;

  private String name;

  @JsonProperty("absolute_magnitude_h")
  private Float absoluteMagnitudeH;

  @JsonProperty("is_potentially_hazardous_asteroid")
  private boolean isPotentiallyHazardousAsteroid;

  @JsonProperty("estimated_diameter")
  private Map<String, EstimatedDiameterByKm> estimatedDiameter;

  @JsonProperty("close_approach_data")
  private List<CloseApproachData> closeApproachData;

  public EstimatedDiameterByKm getKilometers() {
    return estimatedDiameter.get("kilometers");
  }
}
