package com.asteroides.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AsteroidesResponse {

  private String nombre;
  private Double diametro;
  private String velocidad;
  private String fecha;
  private String planeta;

  public AsteroidesResponse(AsteroidsInformation info) {
    this.nombre = info.getName();
    this.diametro = info.getKilometers().calculateDiameter();
    CloseApproachData closeApproachData = info.getCloseApproachData().stream().findFirst().get();
    this.fecha = closeApproachData.getCloseApproachDate();
    this.planeta = closeApproachData.getOrbitingBody();
    this.velocidad = closeApproachData.getRelativeVelocity().getKilometers_per_hour();
  }
}
