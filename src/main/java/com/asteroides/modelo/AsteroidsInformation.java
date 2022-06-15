package com.asteroides.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AsteroidsInformation {

    private String id;
    @JsonProperty("neo_reference_id")
    private String neoReferenceId;
    private String name;
    @JsonProperty("nasa_jpl_url")
    private  String nasaJplUrl;

    @JsonProperty("absolute_magnitude_h")
    private Float absoluteMagnitudeH;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @JsonProperty("estimated_diameter")
    private Map<String, Kilometers> estimatedDiameter;

    public AsteroidsInformation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
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
}
