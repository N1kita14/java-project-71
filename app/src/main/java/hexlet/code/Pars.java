package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.ArrayList;
import java.util.Map;

public class Pars {
    public static Map<String, Object> pars(String text, String type) throws Exception {
        if(type.equals("json")){
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,Object> map = objectMapper.readValue(text, Map.class);
            return map;
        } else if (type.equals("yaml") || type.equals("yml")) {
            ObjectMapper objectMapperYaml = new ObjectMapper(new YAMLFactory());
            Map<String, Object> mapYaml = objectMapperYaml.readValue(text, Map.class);
            return mapYaml;
        }
        return null;
    }
}
