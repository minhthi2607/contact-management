package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    static String PHONE_REGEX = "^[0-9]{10}$";
    static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static boolean isPhone(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }

    public static boolean isEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }
}
