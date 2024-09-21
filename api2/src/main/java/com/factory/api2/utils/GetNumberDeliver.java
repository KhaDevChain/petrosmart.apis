package com.factory.api2.utils;

import java.text.DecimalFormat;

public class GetNumberDeliver {
    
    /**
     * function để hiển thị số có phân cách theo ký tự
     * @param number
     * @param character
     * @return
     */
    public static String Display(int number, String character) {
        character = character.isEmpty() ? "," : character;
        DecimalFormat df = new DecimalFormat("#,###");
        
        return df.format(number).replace(",", character);
    };
}
