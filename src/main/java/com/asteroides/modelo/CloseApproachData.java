package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseApproachData {

    @JsonProperty("close_approach_date")
    private String closeApproachDate;

    @JsonProperty("orbiting_body")
    private String orbitingBody;

    @JsonProperty("relative_velocity")
    private RelativeVelocity relativeVelocity;

    public CloseApproachData() {
    }

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }
}