package com.lab.core.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String format(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}