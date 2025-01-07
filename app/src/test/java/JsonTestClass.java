import hexlet.code.Differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTestClass {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("JsonExpected.txt");
        resultPlain = readFixture("PlainExpected.txt");
        resultStylish = readFixture("StylishExpected.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();

        assertEquals(resultStylish, Differ.generate(filePath1, filePath2));

        assertEquals(resultStylish, Differ.generate(filePath1, filePath2, "stylish"));

        assertEquals(resultPlain, Differ.generate(filePath1, filePath2, "plain"));

        assertEquals(resultJson, Differ.generate(filePath1, filePath2, "json"));

    }


    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
}
