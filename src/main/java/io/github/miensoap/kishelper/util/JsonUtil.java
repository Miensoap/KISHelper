package io.github.miensoap.kishelper.util;

import java.lang.reflect.Field;

public class JsonUtil {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            field.setAccessible(true);

            if (!firstField) {
                jsonBuilder.append(",");
            } else {
                firstField = false;
            }

            String fieldName = field.getName();
            Object value = field.get(obj);

            jsonBuilder.append("\"").append(fieldName).append("\":");
            if (value instanceof String) {
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                jsonBuilder.append(value);
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
