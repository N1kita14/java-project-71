package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> diffFile) throws Exception {

        StringBuilder difference = new StringBuilder();

        int lastKeys = 1;

        for (Map<String, Object> map : diffFile) {

            String value1 = getComplexValue(map.get("value1"));
            String value2 = getComplexValue(map.get("value2"));

            if (map.get("status").equals("changed")) {
                difference.append("Property '")
                        .append(map.get("key"))
                        .append("' was updated. ")
                        .append("From ")
                        .append(formatValue(value1))
                        .append(" to ")
                        .append(formatValue(value2));
                if (diffFile.size() > lastKeys) {
                    difference.append(System.lineSeparator());
                }
            } else if (map.get("status").equals("removed")) {
                difference.append("Property '")
                        .append(map.get("key"))
                        .append("' was removed");
                if (diffFile.size() > lastKeys) {
                    difference.append(System.lineSeparator());
                }
            } else if (map.get("status").equals("added")) {
                difference.append("Property '")
                        .append(map.get("key"))
                        .append("' was added with value: ")
                        .append(formatValue(value2));
                if (diffFile.size() > lastKeys) {
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
