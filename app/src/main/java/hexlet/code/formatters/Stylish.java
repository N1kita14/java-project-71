package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public class Stylish {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws JsonProcessingException {
        Map<String, Object> file12 = new TreeMap<>();
        for(String key: diffFile2.keySet()){
            if(diffFile1.containsKey(key)){
                if(diffFile1.get(key) != null && diffFile2.get(key) != null && diffFile1.get(key).equals(diffFile2.get(key))){
                    file12.put(key, diffFile1.get(key));
                }else{
                    file12.put("- " + key, diffFile1.get(key));
                    file12.put("+ " + key, diffFile2.get(key));
                }
            }else{
                file12.put("+ " + key, diffFile2.get(key));
            }
        }
        for(String key: diffFile1.keySet()){
            if(!diffFile2.containsKey(key)){
                file12.put("- " + key, diffFile1.get(key));
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(file12).replace(",", "\n");
    }
}