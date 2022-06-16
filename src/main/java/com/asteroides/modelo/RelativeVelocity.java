package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelativeVelocity {

    @JsonProperty("kilometers_per_hour")
    private String kilometers_per_hour;

    public RelativeVelocity() {
    }

    public String getKilometers_per_hour() {
        return kilometers_per_hour;
    }

    public void setKilometers_per_hour(String kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }
}
