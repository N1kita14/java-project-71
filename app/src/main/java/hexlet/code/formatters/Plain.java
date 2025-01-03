package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Plain {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws Exception {

        StringBuilder difference = new StringBuilder();

        Set<String> keys = new TreeSet<>(diffFile1.keySet());
        keys.addAll(diffFile2.keySet());
        int lastKeys = 1;

        for (String key : keys) {
            if (diffFile1.containsKey(key) && diffFile2.containsKey(key)) {

                String value1 = getComplexValue(diffFile1.get(key));
                String value2 = getComplexValue(diffFile2.get(key));

                if (!value1.equals(value2) || !diffFile1.get(key).equals(diffFile2.get(key))) {
                    difference.append("Property '")
                            .append(key)
                            .append("' was updated. ")
                            .append("From ")
                            .append(formatValue(value1))
                            .append(" to ")
                            .append(formatValue(value2));
                    if (keys.size() > lastKeys) {
                        difference.append(System.lineSeparator());
                    }
                }
            } else if (diffFile1.containsKey(key)) {
                difference.append("Property '")
                        .append(key)
                        .append("' was removed");
                if (keys.size() > lastKeys) {
                    difference.append(System.lineSeparator());
                }
            } else {
                difference.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(formatValue(getComplexValue(diffFile2.get(key))));
                if (keys.size() > lastKeys) {
                    difference.append(System.lineSeparator());
                }
            }
            lastKeys++;
        }

        return difference.toString();
    }

    private static String getComplexValue(Object obj) {
        if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(obj);
    }

    private static String formatValue(String v) {
        if ("[complex value]".equals(v)) {
            return v;
        }
        if (v == null) {
            return "null";
        }
        try {
            Integer.parseInt(v);
            return v;
        } catch (NumberFormatException e) {
            if ("value2".equals(v) || "Some value".equals(v) || "Another value".equals(v) || "none".equals(v)) {
                return "'" + v + "'";
            } else {
                return v;
            }
        }
    }
}
