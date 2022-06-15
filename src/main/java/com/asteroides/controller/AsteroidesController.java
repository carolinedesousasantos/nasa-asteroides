package com.asteroides.controller;

import com.asteroides.modelo.Asteroides;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/nasa")
public class AsteroidesController {

    private Asteroides asteroides;

    @GetMapping("/asteroides")
    public List<Asteroides> getList(){
        String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=DEMO_KEY";
        RestTemplate restTemplate = new RestTemplate();
        Asteroides asteroides  =  restTemplate.getForObject(url, Asteroides.class);
       return Arrays.asList(asteroides);
    }

}
