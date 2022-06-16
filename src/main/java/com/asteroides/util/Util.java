package com.asteroides.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
  public static String formatCurrentDate(LocalDateTime now) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateFormat = dtf.format(now);
    return dateFormat;
  }
}
