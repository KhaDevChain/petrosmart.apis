package com.factory.api2.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetDatetimeFormat {
    /**
     * Chuyển thành dạng date với format mặc định
     * @return
     */
    public static String DATE() {
        String pattern = "dd/MM/yyyy";
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(current);
    }

    /**
     * Chuyển thành dạng time với format mặc định
     * @return
     */
    public static String TIME() {
        String pattern = "hh:mm:ss";
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(current); 
    }

    /**
     * Chuyển thành dạng date với format cá nhân
     * @param pattern
     * @return
     */
    public static String DATE(String pattern) {
        pattern = pattern.isEmpty() ? "dd/MM/yyyy" : pattern;
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(current);
    }

    /**
     * Chuyển thành dạng time với format cá nhân
     * @param pattern
     * @return
     */
    public static String TIME(String pattern) {
        pattern = pattern.isEmpty() ? "hh:mm:ss" : pattern;
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(current);
    }
}
