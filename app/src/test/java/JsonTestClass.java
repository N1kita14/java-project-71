
import hexlet.code.Pars;
import hexlet.code.formatters.Stylish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonTestClass {

    @Test
    void testDiffJson() {
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
            Map<String, Object> testJson1 = Pars.pars(testFile1, "json");
            Map<String, Object> testJson2 = Pars.pars(testFile2, "json");
            String result = "{\"+ timeout\":20,\"+ verbose\":true,\"- follow\":false,\"- proxy\":\"123.234.53.22\",\"- timeout\":50,\"host\":\"hexlet.io\"}";
            Assertions.assertEquals(result, Stylish.format(testJson1, testJson2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFileYaml() {
        String testFile1Yaml = "host: hexlet.io\n"
                + "timeout: 50\n"
                + "proxy: 123.234.53.22\n"
                + "follow: false";
        String testFile2Yaml = "timeout: 20\n"
                + "verbose: true\n"
                + "host: hexlet.io\n";
        try {
            Map<String, Object> testYaml1 = Pars.pars(testFile1Yaml, "yaml");
            Map<String, Object> testYaml2 = Pars.pars(testFile2Yaml, "yaml");
            String resultYaml = "{\"+ timeout\":20,\"+ verbose\":true,\"- follow\":false,\"- proxy\":\"123.234.53.22\",\"- timeout\":50,\"host\":\"hexlet.io\"}";
            Assertions.assertEquals(resultYaml, Stylish.format(testYaml1, testYaml2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
