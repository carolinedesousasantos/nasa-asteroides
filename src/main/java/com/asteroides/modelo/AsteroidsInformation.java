package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class AsteroidsInformation {

    private String id;

    private String name;

    @JsonProperty("absolute_magnitude_h")
    private Float absoluteMagnitudeH;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @JsonProperty("estimated_diameter")
    private Map<String, Kilometers> estimatedDiameter;

    @JsonProperty("close_approach_data")
    private List<CloseApproachData> closeApproachData;

    public AsteroidsInformation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(Float absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public Map<String, Kilometers> getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(Map<String, Kilometers> estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    public List<CloseApproachData> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachData> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }


}
