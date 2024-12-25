package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
                            .append(formatValue(value1))
                            .append(" to ")
                            .append(formatValue(value2))
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
                        .append("' was added with value: ")
                        .append(formatValue(getComplexValue(diffFile2.get(key))))
                        .append('.')
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

    private static String formatValue(String value) {
        if ("[complex value]".equals(value)) {
            return value;
        }
        if (value == null) {
            return "null";
        }
        try {
            Integer.parseInt(value);
            return value;
        } catch (NumberFormatException e) {
            return "'" + value + "'";
        }
    }
}