package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String files1, String files2, String formatName) throws JsonProcessingException {
        String textFile1 = fileLoad(files1);
        String typeFile1 = getFileType(textFile1);
        Map<String, Object> map1 = Pars.pars(textFile1,typeFile1);
        String textFile2 = fileLoad(files2);
        String typeFile2 = getFileType(textFile2);
        Map<String, Object> map2 = Pars.pars(textFile2,typeFile2);
        if(formatName.equals("json")){
            return Json.format(map1, map2);
        }else if(formatName.equals("plain")){
            return Plain.format(map1, map2);
        }else if(formatName.equals("stylish")){
            return Stylish.format(map1, map2);
        }
        return null;
    }
    public static String fileLoad(String file1){
        try (BufferedReader str = new BufferedReader(new FileReader(file1))){
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = str.readLine()) != null) {
                builder.append(line + "\n");
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getFileType(String pathFile){
        String[] path = pathFile.split("\\.");
        return path[path.length - 1];
    }
}

