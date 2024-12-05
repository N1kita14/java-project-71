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


@ Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
                description = "Compares two configuration files and shows a difference.")

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.*/
public class App{
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;
    /*public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }*/
    public static void main(String[] args) throws JsonProcessingException {
        String jsonLoadRun = fileLoad("C:\\file11.json");
        Map<String, Object> mapJson = Pars.parsJson(jsonLoadRun);
        String jsonLoadRun2 = fileLoad("C:\\file22.json");
        Map<String, Object> mapJson2 = Pars.parsJson(jsonLoadRun2);
        System.out.println(Differ.generate(mapJson, mapJson2));

        String jsonYamlRun = fileLoad("C:\\filepath1.yaml");
        Map<String, Object> mapYaml = Pars.parsYaml(jsonYamlRun);
        String jsonYamlRun2 = fileLoad("C:\\filepath2.yaml");
        Map<String, Object> mapYaml2 = Pars.parsYaml(jsonYamlRun2);
        System.out.println(Differ.generate(mapYaml, mapYaml2));
    }
}