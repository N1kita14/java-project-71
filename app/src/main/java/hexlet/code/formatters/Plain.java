package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> diffFile) throws Exception {

        StringBuilder difference = new StringBuilder();

        int lastKeys = 1;

        for (Map<String, Object> map : diffFile) {

            String value1 = formatValue(map.get("value1"));
            String value2 = formatValue(map.get("value2"));

            if (map.get("status").equals("changed")) {
                difference.append("Property '")
                        .append(map.get("key"))
                        .append("' was updated. ")
                        .append("From ")
                        .append(value1)
                        .append(" to ")
                        .append(value2);
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
                        .append(value2);
                if (diffFile.size() > lastKeys) {
                    difference.append(System.lineSeparator());
                }
            }
            lastKeys++;
        }

        return difference.toString();
    }

    private static String formatValue(Object v) {
        if (v == null) {
            return "null";
        }
        if (v instanceof String) {
            return "'" + v + "'";
        }
        if (v instanceof Map || v instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(v);
    }
}
