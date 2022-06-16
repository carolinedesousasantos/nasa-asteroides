package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EstimatedDiameterByKm {
  @JsonProperty("estimated_diameter_min")
  private Double estimatedDiameterMin;

  @JsonProperty("estimated_diameter_max")
  private Double estimatedDiameterMax;

  @JsonProperty("estimated_diameter")
  public Double calculateDiameter() {
    return (this.estimatedDiameterMin + this.estimatedDiameterMax) / 2;
  }
}
