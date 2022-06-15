package com.asteroides.modelo;

import java.util.List;
import java.util.Map;

public class Asteroides {

    private Map<String, List<AsteroidsInformation>> near_earth_objects;

    public Asteroides() {
    }

    public Map<String, List<AsteroidsInformation>> getNear_earth_objects() {
        return near_earth_objects;
    }

    public void setNear_earth_objects(Map<String, List<AsteroidsInformation>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
}
