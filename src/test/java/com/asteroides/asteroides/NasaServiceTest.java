package com.asteroides.asteroides;

import static org.mockito.Mockito.when;

import com.asteroides.AsteroidesApplication;
import com.asteroides.exceptions.ValueNotAcceptedException;
import com.asteroides.service.NasaService;
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
public class NasaServiceTest {

  @Mock NasaService service;

  @Test
  public void passingValueGreaterThanSeven() throws ValueNotAcceptedException {
    Long day = 8L;
    when(service.getUrl(day)).thenThrow(ValueNotAcceptedException.class);

    Assertions.assertThrows(
        ValueNotAcceptedException.class,
        () -> {
          service.getUrl(day);
        });
  }

  @Test
  public void passingValueSmallerThanOne() {
    Long day = 0L;
    Assertions.assertThrows(
        ValueNotAcceptedException.class,
        () -> {
          service.getUrl(day);
        });
  }
}
