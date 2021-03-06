package com.asteroides.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RelativeVelocity {

  @JsonProperty("kilometers_per_hour")
  private String kilometersPerHour;
}
