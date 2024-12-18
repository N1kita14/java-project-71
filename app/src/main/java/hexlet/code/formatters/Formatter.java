package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2, String styles) throws JsonProcessingException {
    return switch(styles){
        case "stylish" -> Stylish.format(diffFile1, diffFile2);
        case "json" -> Json.format(diffFile1, diffFile2);
        case "plain" -> Plain.format(diffFile1, diffFile2);
        default -> throw new RuntimeException("unknown differ format");
    };
    }
}

