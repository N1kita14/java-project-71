package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.*/
public class App{
    @Parameters(paramLabel = "file1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "file2", description = "path to second file")
    private String filePath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    /*public static void main(String[] args) throws JsonProcessingException {
        String jsonLoadRun = json1Load("C:\\file1.json");
        //System.out.println(jsonLoadRun);
        Map<String, Object> mapJson = parsJson(jsonLoadRun);
        String jsonLoadRun2 = json1Load("C:\\file2.json");
        //System.out.println(jsonLoadRun2);
        Map<String, Object> mapJson2 = parsJson(jsonLoadRun2);
        System.out.println(Differ.generate(mapJson, mapJson2));
    }*/
    public static String json1Load(String file1){
        try (BufferedReader str = new BufferedReader(new FileReader(file1))){
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = str.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String, Object> parsJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = objectMapper.readValue(json, Map.class);
        return map;
    }
}