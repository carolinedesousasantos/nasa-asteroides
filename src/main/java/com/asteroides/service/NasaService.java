package com.asteroides.service;

import com.asteroides.modelo.Asteroides;
import com.asteroides.modelo.AsteroidsInformation;
import com.asteroides.util.Util;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaService {

  public String getUrl(Long day) {
    String star_date = Util.formatCurrentDate(LocalDateTime.now());
    String end_date = Util.formatCurrentDate(LocalDateTime.now().plusDays(day));
    return
        "https://api.nasa.gov/neo/rest/v1/feed?start_date="
            + star_date
            + "&end_date="
            + end_date
            + "&api_key=DEMO_KEY";
  }

  public List<Asteroides> getNasaList(String url) {
    RestTemplate restTemplate = new RestTemplate();
    Asteroides asteroides = restTemplate.getForObject(url, Asteroides.class);
    return Arrays.asList(asteroides);
  }

  public List<AsteroidsInformation> getPotentiallyHazardousAsteroid(List<Asteroides> list) {
    return list.stream()
            .map(objects -> objects.getNear_earth_objects().values())
            .flatMap(l -> l.stream())
            .flatMap(List::stream)
            .filter(AsteroidsInformation::isPotentiallyHazardousAsteroid)
            .collect(Collectors.toList());
  }
}
