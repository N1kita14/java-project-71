import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Differ;
import hexlet.code.Pars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonTestClass {

    @Test
    void testDiffJson(){
        String testFile1 = "{\n" +
                "  \"host\": \"hexlet.io\",\n" +
                "  \"timeout\": 50,\n" +
                "  \"proxy\": \"123.234.53.22\",\n" +
                "  \"follow\": false\n" +
                "}";
        String testFile2 = "{\n" +
                        "  \"timeout\": 20,\n" +
                        "  \"verbose\": true,\n" +
                        "  \"host\": \"hexlet.io\"\n" +
                        "}";
        try {
            String testJson = Differ.generate(Pars.parsJson(testFile1), Pars.parsJson(testFile2));
            String result = "{\"+ timeout\":20,\"+ verbose\":true,\"- follow\":false,\"- proxy\":\"123.234.53.22\",\"- timeout\":50,\"host\":\"hexlet.io\"}";
            Assertions.assertEquals(result, testJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testFileYaml(){
        String testFile1Yaml = "host: hexlet.io" +
                "timeout: 50\n" +
                "proxy: 123.234.53.22\n" +
                "follow: false";
        String testFile2Yaml = "timeout: 20\n" +
                "verbose: true\n" +
                "host: hexlet.io\n";
        try {
            String testYaml = Differ.generate(Pars.parsYaml(testFile1Yaml), Pars.parsYaml(testFile2Yaml));
            String resultYaml = "{\"+ timeout\":20,\"+ verbose\":true,\"- follow\":false,\"- proxy\":\"123.234.53.22\",\"- timeout\":50,\"host\":\"hexlet.io\"}";
            Assertions.assertEquals(resultYaml, testYaml);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
