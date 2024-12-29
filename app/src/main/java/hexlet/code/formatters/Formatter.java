package hexlet.code.formatters;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2, String styles) throws Exception {
        return switch (styles) {
            case "stylish" -> Stylish.format(diffFile1, diffFile2);
            case "json" -> Json.format(diffFile1, diffFile2);
            case "plain" -> Plain.format(diffFile1, diffFile2);
            default -> throw new RuntimeException("unknown differ format");
        };
    }
}