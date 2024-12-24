package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class Plain {
    public static String format(Map<String, Object> diffFile1, Map<String, Object> diffFile2) throws Exception {

        StringBuilder difference = new StringBuilder();

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(diffFile1.keySet());
        keys.addAll(diffFile2.keySet());

        for(String key: keys){
            if(diffFile1.containsKey(key) && diffFile2.containsKey(key)){
                if(diffFile1.get(key) != null && diffFile2.get(key) != null && diffFile1.get(key).equals(diffFile2.get(key))){
                    difference.append("Property ").append(key).append(" was update").append(". ").append("From ").append(diffFile1.get(key)).append(" to ").append(diffFile2.get(key)).append(System.lineSeparator());
                }else{
                    difference.append("Property ").append(key).append(" was added with value: [").append(diffFile2.get(key)).append("].").append(System.lineSeparator());
                }
            }else{
                difference.append("Property ").append(key).append(" was update").append(". ").append("From ").append(diffFile1.get(key)).append(" to ").append(diffFile2.get(key)).append(System.lineSeparator());
            }
        }
        for(String key: diffFile1.keySet()){
            if(!diffFile2.containsKey(key)){
                difference.append("Property ").append(key).append(" was removed.").append(System.lineSeparator());
            }
        }
        return difference.toString();
    }
}
