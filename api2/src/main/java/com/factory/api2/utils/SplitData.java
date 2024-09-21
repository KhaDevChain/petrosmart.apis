package com.factory.api2.utils;

import java.util.HashMap;
import java.util.Map;

public class SplitData {

    /**
     * Tách chuỗi ra Map
     * @param fuels
     * @return
     */
    public static Map<String, String> FuelsList (String fuels) {
        if (fuels.isEmpty()) {
            return null;
        }

        Map<String, String> result = new HashMap<String, String>();
        String[] fuels_ = fuels.split(";");
        for (String fuel : fuels_) {
            String[] data = fuel.split(",");
            result.put(data[0], data[1]);
        }

        return result;
    }
}
