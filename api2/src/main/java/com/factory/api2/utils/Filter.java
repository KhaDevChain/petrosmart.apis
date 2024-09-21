package com.factory.api2.utils;

import java.text.Normalizer;

public class Filter {
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String VALID_PHONE_REGEX = "^(0|\\+84)[0-9]{9}$";
    public static final String VALID_NUMBER_REGEX = "^\\d+$";
    public static final String VALID_WORD_REGEX = "^[a-zA-Z]+$";

    /**
     * function kiểm tra email có hợp lệ không
     * @param email
     * @return
     */
    public boolean Email_Regex(String email) {
        return email.isEmpty() ? false : email.matches(VALID_EMAIL_ADDRESS_REGEX);
    }

    /**
     * function kiểm tra phone có hợp lệ không
     * @param phone
     * @return
     */
    public boolean Phone_Regex(String phone) {
        return phone.isEmpty() ? false : phone.matches(VALID_PHONE_REGEX);
    }

    /**
     * function kiểm tra đây có phải là số
     * @param number
     * @return
     */
    public boolean Number_Regex(String number) {
        return number.isEmpty() ? false : number.matches(VALID_NUMBER_REGEX);
    }

    /**
     * function kiểm tra đây có phải là dạng chữ khác số
     * @param word
     * @return
     */
    public boolean Word_Regex(String word) {
        return word.isEmpty() ? false : word.matches(VALID_WORD_REGEX);
    }

    /**
     * function kiểm tra kiểu dữ liệu có như mong muốn không
     * @param obj
     * @param typeWish
     * @return
     */
    public boolean Typeof_Object (Object obj, String typeWish) {
        return (obj == null || typeWish.isEmpty()) ? false : obj.getClass().getSimpleName().equals(typeWish);
    }

    /**
     * function giúp xử lý loại bỏ dấu trong nội dung
     * @param content
     * @return
     */
    public String Remove_Accent(String content) {
        // chuyển các ký tự có dấu thành dạng tổ hợp
        String nomarlized = Normalizer.normalize(content, Normalizer.Form.NFD);

        // loại bỏ các dấu ă, â, ô, ơ, ê
        String withoutAccent = nomarlized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // loại bỏ ký tự đặc biệt
        withoutAccent = withoutAccent.replaceAll("Đ", "D");
        withoutAccent = withoutAccent.replaceAll("đ", "d");

        return withoutAccent;
    }
}
