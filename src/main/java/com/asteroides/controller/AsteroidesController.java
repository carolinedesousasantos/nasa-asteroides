package com.asteroides.controller;

import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.modelo.Asteroides;;
import com.asteroides.modelo.AsteroidsInformation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nasa")
public class AsteroidesController {

    private Asteroides asteroides;

    public  String  formatCurrentDate(LocalDateTime now){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dtf.format(now));
        String dateFormat = dtf.format(now);
        return dateFormat;
    }

    @PostMapping({"/asteroides/{day}"})
    public List<AsteroidsInformation> passParameterToDate(@PathVariable Long day) throws ValueNotAcceptedException {
        if (day >0 && day<= 7){
            String star_date = formatCurrentDate(LocalDateTime.now());
            String end_date=formatCurrentDate(LocalDateTime.now().plusDays(day));
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date="+star_date+"&end_date="+end_date+"&api_key=DEMO_KEY";
            return getAsteroidsInformations(url);
        }else{
            throw new ValueNotAcceptedException();
        }
    }

    private List<AsteroidsInformation> getAsteroidsInformations(String url) {
        RestTemplate restTemplate = new RestTemplate();
        Asteroides asteroides  =  restTemplate.getForObject(url, Asteroides.class);
        List<Asteroides> asteroidesList = Arrays.asList(asteroides);

        //get hazardous
        List<AsteroidsInformation> potentiallyHazardousAsteroid = asteroidesList.stream().map(objects -> {
            return objects.getNear_earth_objects().values();
        }).flatMap(l -> l.stream()).flatMap(List::stream).filter(a -> {
            return a.isPotentiallyHazardousAsteroid() == true;
        }).collect(Collectors.toList());
        return potentiallyHazardousAsteroid;
    }

}
