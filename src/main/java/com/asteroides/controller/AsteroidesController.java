package com.asteroides.controller;

import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.modelo.*;
import com.asteroides.service.NasaService;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AsteroidesController {

  private Asteroides asteroides;

  @Autowired private NasaService nasaService;

  @PostMapping({"asteroides/{day}"})
  public List<AsteroidesResponse> getNasaList(@PathVariable Long day)
      throws ValueNotAcceptedException {
    String url = nasaService.getUrl(day);
    return getAsteroidsInformation(url);
  }

  private List<AsteroidesResponse> getAsteroidsInformation(String url) {

    List<Asteroides> asteroidesList = nasaService.getNasaList(url);

    List<AsteroidsInformation> potentiallyHazardousAsteroid =
        nasaService.getPotentiallyHazardousAsteroid(asteroidesList);

    List<AsteriodWithKilometer> asteriodWithKilometers = new ArrayList<>();
    for (AsteroidsInformation a : potentiallyHazardousAsteroid) {
      EstimatedDiameterByKm km = a.getKilometers();
      asteriodWithKilometers.add(new AsteriodWithKilometer(a.getId(), km.calculateDiameter()));
    }

    List biggestAsteroids =
        asteriodWithKilometers.stream()
            .sorted(
                Comparator.comparingDouble(AsteriodWithKilometer::getAverageDiameter).reversed())
            .limit(3)
            .map(AsteriodWithKilometer::getId)
            .collect(Collectors.toList());

    List<AsteroidsInformation> asteroidsList =
        potentiallyHazardousAsteroid.stream()
            .filter(a -> biggestAsteroids.contains(a.getId()))
            .collect(Collectors.toList());

    return asteroidsList.stream()
        .map(AsteroidesResponse::new)
        .sorted(Comparator.comparing(AsteroidesResponse::getDiametro).reversed())
        .collect(Collectors.toList());
  }
}
