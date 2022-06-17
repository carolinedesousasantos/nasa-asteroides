package com.asteroides.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

  private Util() {}

  public static String formatCurrentDate(LocalDateTime now) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return dtf.format(now);
  }
}
