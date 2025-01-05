package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> map1, Map<String, Object> map2, String styles) throws Exception {

        List<Map<String, Object>> treeMaps = Tree.getDiff(map1, map2);

        return switch (styles) {
            case "stylish" -> Stylish.format(treeMaps);
            case "json" -> Json.format(treeMaps);
            case "plain" -> Plain.format(treeMaps);
            default -> throw new RuntimeException("unknown differ format");
        };
    }
}
