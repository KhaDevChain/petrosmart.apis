package com.factory.api2.utils.model_utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.factory.api2.utils.enum_.MethodPayEnum;

public class MethodPay {

    @SuppressWarnings("rawtypes")
    public static String TYPES(MethodPayEnum key) {
        Map<Enum, String> type = Map.of(
            MethodPayEnum.CASH, "Tiền mặt",
            MethodPayEnum.CASH_TRANSFER, "Tiền mặt/Chuyển khoản",
            MethodPayEnum.TRANSFER, "Chuyển khoản",
            MethodPayEnum.DEBT, "Ghi nợ"
        );

        return type.get(key);
    }

    public static List<String> METHOD() {
        List<String> list = new ArrayList<String>();
        list.add("Tiền mặt");
        list.add("Tiền mặt/Chuyển khoản");
        list.add("Chuyển khoản");
        list.add("Ghi nợ");
        return list;
    }
}