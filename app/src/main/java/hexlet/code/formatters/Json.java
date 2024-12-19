package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Json {
    public static String format(Map<String, Object> diffFile1) throws JsonProcessingException {
        //List<Map<String, Object>> list = new ArrayList<>();
        //list.add(diffFile1);
        //list.add(diffFile2);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diffFile1);
    }
}
