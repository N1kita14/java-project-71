package hexlet.code;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        if(args[0].equals("-h")){
            System.out.println("Usage: gendiff [-hV] [-f=format] filepath1 filepath2\n" +
                    "Compares two configuration files and shows a difference.\n" +
                    "      filepath1         path to first file\n" +
                    "      filepath2         path to second file\n" +
                    "  -f, --format=format   output format [default: stylish]\n" +
                    "  -h, --help            Show this help message and exit.\n" +
                    "  -V, --version         Print version information and exit.");
        }
    }
}