package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;

public class Plain {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws Exception {

        StringBuilder difference = new StringBuilder();

        Set<String> keys = new TreeSet<>(diffFile1.keySet());
        keys.addAll(diffFile2.keySet());

        for (String key : keys) {
            if (diffFile1.containsKey(key) && diffFile2.containsKey(key)) {

                String value1 = getComplexValue(diffFile1.get(key));
                String value2 = getComplexValue(diffFile2.get(key));

                if (!value1.equals(value2)) {
                    difference.append("Property '")
                            .append(key)
                            .append("' was updated. ")
                            .append("From ")
                            .append(value1)
                            .append(" to ")
                            .append(value2)
                            .append(System.lineSeparator());
                }
            } else if (diffFile1.containsKey(key)) {
                difference.append("Property '")
                        .append(key)
                        .append("' was removed.")
                        .append(System.lineSeparator());
            } else {
                difference.append("Property '")
                        .append(key)
                        .append("' was added with value: [")
                        .append(getComplexValue(diffFile2.get(key)))
                        .append("].")
                        .append(System.lineSeparator());
            }
        }

        return difference.toString();
    }

    private static String getComplexValue(Object obj) {
        if (obj instanceof Object[]) {
            return "[complex value]";
        }
        return String.valueOf(obj);
    }
}