package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Formatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Differ {
    public static String generate(String files1, String files2, String formatName) throws JsonProcessingException {
        String textFile1 = fileLoad(files1);
        String typeFile1 = getFileType(files1);
        Map<String, Object> map1 = Pars.pars(textFile1,typeFile1);
        String textFile2 = fileLoad(files2);
        String typeFile2 = getFileType(files2);
        Map<String, Object> map2 = Pars.pars(textFile2,typeFile2);
        return Formatter.format(map1, map2, formatName);
    }

    public static String generate(String files1, String files2) throws JsonProcessingException {
        String textFile1 = fileLoad(files1);
        String typeFile1 = getFileType(files1);
        Map<String, Object> map1 = Pars.pars(textFile1,typeFile1);
        String textFile2 = fileLoad(files2);
        String typeFile2 = getFileType(files2);
        Map<String, Object> map2 = Pars.pars(textFile2,typeFile2);
        return Formatter.format(map1, map2, "stylish");
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

