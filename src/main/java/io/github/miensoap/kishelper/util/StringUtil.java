package io.github.miensoap.kishelper.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class StringUtil {
    public static String encloseInSingleQuote(String string) {
        return "'%s'".formatted(string);
    }

    public static String convertToDateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return date.format(formatter);
    }
}
