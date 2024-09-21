package com.factory.api2.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostStringOutDatetime {

    /**
     * function sử dụng để chuyển string thành datetime
     * @param datetime
     * @return
     */
    public LocalDateTime getLocalDateTime(String datetime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
            return localDateTime;
        } catch (Exception e) {
            return null;
        }
    } 

    /**
     * function sử dụng để chuyển string thành date
     * @param datetime
     * @return
     */
    public LocalDateTime getLocalDate(String datetime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
            return localDateTime;
        } catch (Exception e) {
            return null;
        }
    } 

    /**
     * function sử dụng để chuyển string thành time
     * @param datetime
     * @return
     */
    public LocalDateTime getLocalTime(String datetime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
            return localDateTime;
        } catch (Exception e) {
            return null;
        }
    } 
}
