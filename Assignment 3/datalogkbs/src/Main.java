import cli.Command;
import cli.CommandLine;
import cli.strategy.Strategy;
import com.company.lib.MultiValueMap;
import com.company.lib.ProgramParser;
import helper.InputHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Welcome to datalog kbs demo. Enter 'help' or 'exit' to know more");
        main.init();
    }

    public void init() {
        try {
            CommandLine cli = CommandLine.getInstance();
            while (true) {
                Command command = cli.parse(InputHelper.getUserInput("Enter the command:"));
                Strategy strategy = Command.getStrategy(command.getType());
                strategy.run(command);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            init();
        }
    }

    public static void main() throws IOException {
        File initialFile = new File("C:\\Users\\madhu\\MACS_Courses\\Summer22\\kbs\\kbs-assignments\\Assignment_3\\datalogkbs\\src\\input.txt");
        InputStream targetStream = new FileInputStream(initialFile);

        Arrays.stream(ProgramParser.parseKB(targetStream)).forEach(clause -> {
            System.out.println("\nClause: " + clause);
            System.out.println("Type: " + clause.getType());
            switch (clause.getType()) {
                case RULE:
                    System.out.println("Head: " + clause.getHead());
                    System.out.println("Goals: " +
                            Arrays.toString(clause.getGoals()));
                    System.out.println("Head variable(s): " +
                            Arrays.toString(clause.getHead().getVariables()));
                    System.out.println("Rule variable(s): " +
                            Arrays.toString(clause.getVariables()));
                    String input = InputHelper.getInputUsingVariables(clause.getHead().getVariables());
                    System.out.println("Goal(1) Instantiate X=2, Y=1: " +
                            clause.getGoals()[0].substitute(
                                    MultiValueMap.parse(input, true)));
            }
        });
    }
}
