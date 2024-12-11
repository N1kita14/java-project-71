package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Json {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws JsonProcessingException {
        Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
        for(String key: diffFile2.keySet()){
            if(diffFile1.containsKey(key)){
                if(diffFile1.get(key) != null && diffFile2.get(key) != null && diffFile1.get(key).equals(diffFile2.get(key))){
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("oldValue", diffFile1.get(key));
                    map2.put("newValue", diffFile2.get(key));
                    map2.put("status", "unchanged");
                    map.put(key, map2);
                }else{
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("oldValue", diffFile1.get(key));
                    map2.put("newValue", diffFile2.get(key));
                    map2.put("status", "changed");
                    map.put(key, map2);
                }
            }else{
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("newValue", diffFile2.get(key));
                map2.put("status", "added");
                map.put(key, map2);
            }
        }
        for(String key: diffFile1.keySet()){
            if(!diffFile2.containsKey(key)){
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("oldValue", diffFile1.get(key));
                map2.put("status", "deleted");
                map.put(key, map2);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }
}
