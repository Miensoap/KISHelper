package io.github.miensoap.kishelper.util;

public abstract class StringUtil {
    public static String encloseInSingleQuote(String string) {
        return "'%s'".formatted(string);
    }
}
