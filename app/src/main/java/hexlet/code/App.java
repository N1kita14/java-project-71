package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.*/
public final class App implements Callable<Integer> {

    @Parameters(paramLabel = "file1", description = "path to first file")
    private String filePath1;

    @Parameters(paramLabel = "file2", description = "path to second file")
    private String filePath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filePath1, filePath2, format));
        return 0;
    }
}
