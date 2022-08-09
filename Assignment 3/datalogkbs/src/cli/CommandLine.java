package cli;

import java.util.Objects;

public class CommandLine {

    private static CommandLine cli;

    public Command parse(String command) {
        command = command.trim();
        String[] splitArr = command.split(" ");
        if (splitArr.length == 0) {
            throw new IllegalStateException("No command found, Try 'help'");
        }
        Command.Type type = Command.getType(splitArr[0]);
        if (Objects.isNull(type)) {
            throw new IllegalStateException("No command found, Try 'help'");
        }
        String options = "";
        if (splitArr.length > 1) {
            for (int i = 1; i < splitArr.length; i++) {
                options = splitArr[i] + " ";
            }
        }
        return new Command(type, options);
    }

    public void run(Command command) {

    }


    public static CommandLine getInstance() {
        if (Objects.isNull(cli)) {
            cli = new CommandLine();
        }
        return cli;
    }
}
