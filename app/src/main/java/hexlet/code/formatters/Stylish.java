package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diffFile) throws Exception {

        StringBuilder difference = new StringBuilder();

        difference.append("{").append(System.lineSeparator());

        for (Map<String, Object> map : diffFile) {

            String value1 = stringify(map.get("value1"));
            String value2 = stringify(map.get("value2"));

            if (map.get("status").equals("unchanged")) {
                difference.append("    ").append(map.get("key")).append(": ")
                        .append(value2).append(System.lineSeparator());
            } else if (map.get("status").equals("changed")) {
                difference.append("  - ").append(map.get("key")).append(": ")
                        .append(value1).append(System.lineSeparator());
                difference.append("  + ").append(map.get("key")).append(": ")
                        .append(value2).append(System.lineSeparator());
            } else if (map.get("status").equals("removed")) {
                difference.append("  - ").append(map.get("key")).append(": ")
                        .append(value1).append(System.lineSeparator());
            } else if (map.get("status").equals("added")) {
                difference.append("  + ").append(map.get("key")).append(": ")
                        .append(value2).append(System.lineSeparator());
            }
        }
        difference.append("}");

        return difference.toString();
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }

        return value.toString();
    }
}
