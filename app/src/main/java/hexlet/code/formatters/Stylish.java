package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> diffFile) throws Exception {

        StringBuilder difference = new StringBuilder();

        difference.append("{").append(System.lineSeparator());

        for (Map<String, Object> map : diffFile) {
            if (map.get("status").equals("unchanged")) {
                difference.append("    ").append(map.get("key")).append(": ")
                        .append(map.get("value2")).append(System.lineSeparator());
            } else if (map.get("status").equals("changed")) {
                difference.append("  - ").append(map.get("key")).append(": ")
                        .append(map.get("value1")).append(System.lineSeparator());
                difference.append("  + ").append(map.get("key")).append(": ")
                        .append(map.get("value2")).append(System.lineSeparator());
            } else if (map.get("status").equals("removed")) {
                difference.append("  - ").append(map.get("key")).append(": ")
                        .append(map.get("value1")).append(System.lineSeparator());
            } else if (map.get("status").equals("added")) {
                difference.append("  + ").append(map.get("key")).append(": ")
                        .append(map.get("value2")).append(System.lineSeparator());
            }
        }
        difference.append("}");

        return difference.toString();
    }
}
