package hexlet.code.formatters;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> map1, Map<String, Object> map2, String styles) throws Exception {
        return switch (styles) {
            case "stylish" -> Stylish.format(map1, map2);
            case "json" -> Json.format(map1, map2);
            case "plain" -> Plain.format(map1, map2);
            default -> throw new RuntimeException("unknown differ format");
        };
    }
}
