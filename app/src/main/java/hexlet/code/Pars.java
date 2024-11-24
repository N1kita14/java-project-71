package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Pars {
    public static Map<String, Object> parsJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = objectMapper.readValue(json, Map.class);
        return map;
    }
    public static Map<String, Object> parsYaml(String yaml) throws JsonProcessingException {
        ObjectMapper objectMapperYaml = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapYaml = objectMapperYaml.readValue(yaml, Map.class);
        return mapYaml;
    }
}
