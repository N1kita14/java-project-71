package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class Json {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(diffFile1);
        list.add(diffFile2);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
    }
}
