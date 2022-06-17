package com.asteroides.controller;

import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.model.*;
import com.asteroides.service.NasaService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AsteroidesController {

  private Asteroides asteroides;

  @Autowired private NasaService nasaService;

  @GetMapping({"asteroides/{day}"})
  public List<AsteroidesResponse> getNasaList(@PathVariable Long day)
      throws ValueNotAcceptedException {
    return nasaService.getAsteroidsInformation(day);
  }
}
