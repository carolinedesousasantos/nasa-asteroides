package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CloseApproachData {

  @JsonProperty("close_approach_date")
  private String closeApproachDate;

  @JsonProperty("orbiting_body")
  private String orbitingBody;

  @JsonProperty("relative_velocity")
  private RelativeVelocity relativeVelocity;
}
