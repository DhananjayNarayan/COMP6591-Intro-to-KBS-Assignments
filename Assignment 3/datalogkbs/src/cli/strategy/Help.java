package cli.strategy;

import cli.Command;

public class Help implements Strategy {

    @Override
    public boolean run(Command command) {
        System.out.println("Below are the functionalities of each command");
        System.out.println();
        for (Command.Type type : Command.Type.values()) {
            System.out.printf("%s -> %s%n", type, Command.getHelperMessage(type));
        }
        System.out.println();
        return false;
    }
}
