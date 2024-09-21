package com.factory.api2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.factory.api2.utils.enum_.MethodPayEnum;

public class MethodPay {

    /**
     * Function tìm kiếm phương thức thanh toán qua ENUM
     * @param key
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String TYPES(MethodPayEnum key) {
        Map<Enum, String> type = Map.of(
            MethodPayEnum.CASH, "Tiền mặt",
            MethodPayEnum.CASH_TRANSFER, "Tiền mặt/Chuyển khoản",
            MethodPayEnum.TRANSFER, "Chuyển khoản",
            MethodPayEnum.DEBT, "Ghi nợ",
            MethodPayEnum.MARK, "Đánh dấu"
        );

        return type.get(key);
    }

    /**
     * Function lấy danh sách tất cả các phương thức thanh toán
     * @return
     */
    public static List<String> METHOD() {
        List<String> list = new ArrayList<String>();
        list.add("Tiền mặt");
        list.add("Tiền mặt/Chuyển khoản");
        list.add("Chuyển khoản");
        list.add("Ghi nợ");

        // đánh dấu này dùng trong trường hợp lường trụ hoặc hồi bồn
        list.add("Đánh dấu");
        return list;
    }
}