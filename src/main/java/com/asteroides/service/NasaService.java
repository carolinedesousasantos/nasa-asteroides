package com.asteroides.service;

import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.model.*;
import com.asteroides.util.Util;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaService {

  @Value("${nasa.apyKey}")
  private String apiKey;

  public String getUrl(Long day) throws ValueNotAcceptedException {
    String starDate = Util.formatCurrentDate(LocalDateTime.now());
    String endDate = Util.formatCurrentDate(LocalDateTime.now().plusDays(day));

    if (day > 0 && day <= 7) {
      return "https://api.nasa.gov/neo/rest/v1/feed?start_date="
          + starDate
          + "&end_date="
          + endDate
          + "&api_key="+apiKey;
    } else {
      throw new ValueNotAcceptedException();
    }
  }

  public List<Asteroides> getNasaList(String url) {
    RestTemplate restTemplate = new RestTemplate();
    Asteroides asteroides = restTemplate.getForObject(url, Asteroides.class);
    return Arrays.asList(asteroides);
  }

  public List<AsteroidesResponse> getAsteroidsInformation(Long day)
      throws ValueNotAcceptedException {
    String url = getUrl(day);
    List<Asteroides> nasaList = getNasaList(url);

    List<AsteroidsInformation> potentiallyHazardousAsteroidList =
        getPotentiallyHazardousAsteroid(nasaList);

    List<AsteriodWithKilometer> asteroidWithKilometers =
        getDiameterInfo(potentiallyHazardousAsteroidList);

    List<String> biggestAsteroids = getBiggestAsteroids(asteroidWithKilometers);

    List<AsteroidsInformation> asteroidsList =
        getBiggestDangerousAsteroids(potentiallyHazardousAsteroidList, biggestAsteroids);

    return getFinalListWith3BiggestDangerousAsteroids(asteroidsList);
  }

  public List<AsteroidsInformation> getPotentiallyHazardousAsteroid(List<Asteroides> list) {
    return list.stream()
        .map(objects -> objects.getNearEarthObjects().values())
        .flatMap(l -> l.stream())
        .flatMap(List::stream)
        .filter(AsteroidsInformation::isPotentiallyHazardousAsteroid)
        .collect(Collectors.toList());
  }

  public List<AsteroidesResponse> getFinalListWith3BiggestDangerousAsteroids(
      List<AsteroidsInformation> asteroidsList) {
    return asteroidsList.stream()
        .map(AsteroidesResponse::new)
        .sorted(Comparator.comparing(AsteroidesResponse::getDiametro).reversed())
        .collect(Collectors.toList());
  }

  public List<AsteroidsInformation> getBiggestDangerousAsteroids(
      List<AsteroidsInformation> potentiallyHazardousAsteroid, List<String> biggestAsteroidsIds) {
    return potentiallyHazardousAsteroid.stream()
        .filter(a -> biggestAsteroidsIds.contains(a.getId()))
        .collect(Collectors.toList());
  }

  public List<AsteriodWithKilometer> getDiameterInfo(
      List<AsteroidsInformation> potentiallyHazardousAsteroid) {
    List<AsteriodWithKilometer> asteroidWithKilometers = new ArrayList<>();
    for (AsteroidsInformation a : potentiallyHazardousAsteroid) {
      EstimatedDiameterByKm km = a.getKilometers();
      asteroidWithKilometers.add(new AsteriodWithKilometer(a.getId(), km.calculateDiameter()));
    }
    return asteroidWithKilometers;
  }

  public List<String> getBiggestAsteroids(List<AsteriodWithKilometer> asteroidWithKilometers) {
    return asteroidWithKilometers.stream()
        .sorted(Comparator.comparingDouble(AsteriodWithKilometer::getAverageDiameter).reversed())
        .limit(3)
        .map(AsteriodWithKilometer::getId)
        .collect(Collectors.toList());
  }
}
