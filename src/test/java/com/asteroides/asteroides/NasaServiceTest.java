package com.asteroides.asteroides;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.asteroides.AsteroidesApplication;
import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.model.*;
import com.asteroides.service.NasaService;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = AsteroidesApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NasaServiceTest {

  @Mock NasaService service;

  @Test
  void passingValueGreaterThanSeven() throws ValueNotAcceptedException {
    Long day = 8L;
    when(service.getUrl(day)).thenThrow(ValueNotAcceptedException.class);

    Assertions.assertThrows(
        ValueNotAcceptedException.class,
        () -> {
          service.getUrl(day);
        });
  }

  @Test
  void passingValueSmallerThanOne() throws ValueNotAcceptedException {
    Long day = 0L;
    when(service.getUrl(day)).thenThrow(ValueNotAcceptedException.class);
    Assertions.assertThrows(
        ValueNotAcceptedException.class,
        () -> {
          service.getUrl(day);
        });
  }

  @Test
  void getPotentiallyHazardousAsteroid() throws ValueNotAcceptedException {

    List<AsteroidsInformation> asteriodesInfo =
        createAsteriodesInfo().stream()
            .filter(f -> f.isPotentiallyHazardousAsteroid())
            .collect(Collectors.toList());

    when(service.getPotentiallyHazardousAsteroid(any())).thenReturn(asteriodesInfo);

    List<AsteroidsInformation> potentiallyHazardousAsteroid =
        service.getPotentiallyHazardousAsteroid(null);

    Assertions.assertEquals(3, potentiallyHazardousAsteroid.size());
  }

  private List<Asteroides> craeteAsteroides() {
    List<AsteroidsInformation> list = createAsteriodesInfo();

    List<Asteroides> asteroidesList = new ArrayList<>();

    Asteroides asteroides = new Asteroides();

    Map<String, List<AsteroidsInformation>> map = new HashMap<>();

    map.put("near_earth_objects", list);
    asteroides.setNearEarthObjects(map);

    asteroidesList.add(asteroides);
    return asteroidesList;
  }

  private List<AsteroidsInformation> createAsteriodesInfo() {
    Double diameter1 = getDiameter(0.5562, 0.94563331);
    RelativeVelocity velocity1 = getRelativeVelocity("8265781.6544");
    CloseApproachData data1 = getCloseApproachData(velocity1, "Earth", "2022-06-19");

    Double diameter2 = getDiameter(0.5763098, 0.946735911563331);
    RelativeVelocity velocity2 = getRelativeVelocity("72145.92588973");
    CloseApproachData data2 = getCloseApproachData(velocity2, "Earth", "2022-06-20");

    Double diameter3 = getDiameter(0.735476309586789438, 0.94857834563331);
    RelativeVelocity velocity3 = getRelativeVelocity("43243877.957198333");
    CloseApproachData data3 = getCloseApproachData(velocity3, "Earth", "2022-06-21");

    Double diameter4 = getDiameter(0.125763098, 0.93214563331);
    RelativeVelocity velocity4 = getRelativeVelocity("34275.54353");
    CloseApproachData data4 = getCloseApproachData(velocity4, "Saturno", "2022-06-22");

    Map map1 = new HashMap();
    map1.put("kilometers", diameter1);

    Map map2 = new HashMap();
    map2.put("kilometers", diameter2);

    Map map3 = new HashMap();
    map3.put("kilometers", diameter3);

    Map map4 = new HashMap();
    map4.put("kilometers", diameter4);

    AsteroidsInformation a1 = getAsteroidsInformation("1", "asteroide1", 1F, data1, map1, true);
    AsteroidsInformation a2 = getAsteroidsInformation("2", "asteroide2", 2F, data2, map2, false);
    AsteroidsInformation a3 = getAsteroidsInformation("3", "asteroide3", 3F, data3, map3, true);
    AsteroidsInformation a4 = getAsteroidsInformation("4", "asteroide4", 4F, data4, map4, true);

    List<AsteroidsInformation> list = new ArrayList<>();
    list.add(a1);
    list.add(a2);
    list.add(a3);
    list.add(a4);

    return list;
  }

  private AsteroidsInformation getAsteroidsInformation(
      String id,
      String name,
      Float magnitudH,
      CloseApproachData data,
      Map map,
      boolean potentiallyHazardous) {
    AsteroidsInformation a1 = new AsteroidsInformation();
    a1.setId(id);
    a1.setName(name);
    a1.setEstimatedDiameter(map);
    a1.setAbsoluteMagnitudeH(magnitudH);
    a1.setCloseApproachData(Arrays.asList(data));
    a1.setPotentiallyHazardousAsteroid(potentiallyHazardous);
    return a1;
  }

  private CloseApproachData getCloseApproachData(
      RelativeVelocity velocity, String planet, String date) {
    CloseApproachData data = new CloseApproachData();
    data.setRelativeVelocity(velocity);
    data.setOrbitingBody(planet);
    data.setCloseApproachDate(date);
    return data;
  }

  private RelativeVelocity getRelativeVelocity(String setKilometers_per_hour) {
    RelativeVelocity velocity = new RelativeVelocity();
    velocity.setKilometersPerHour(setKilometers_per_hour);
    return velocity;
  }

  private Double getDiameter(Double min, Double max) {
    EstimatedDiameterByKm km = new EstimatedDiameterByKm();
    km.setEstimatedDiameterMin(min);
    km.setEstimatedDiameterMax(max);
    Double diameter = km.calculateDiameter();
    return diameter;
  }
}
