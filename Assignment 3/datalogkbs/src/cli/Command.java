package cli;

import cli.strategy.*;
import datalogQuery.DatalogQuery;

public class Command {

    private final Type type;
    private final String options;

    public Command(Type type, String options) {
        this.type = type;
        this.options = options;
    }


    public Type getType() {
        return type;
    }

    public String getOptions() {
        return options;
    }

    public static Type getType(String s) {
        switch (s) {
            case "help": {
                return Type.help;
            }
            case "dl": {
                return Type.dl;
            }
            case "pl": {
                return Type.pl;
            }
            case "s_rules": {
                return Type.s_rules;
            }
            case "s_details": {
                return Type.s_details;
            }
            case "print": {
                return Type.print;
            }
            case "query": {
                return Type.query;
            }
            case "exit": {
                return Type.exit;
            }
        }
        throw new IllegalStateException("Command not found");
    }

    public static String getHelperMessage(Type type) {
        switch (type) {
            case dl: {
                return "Loads datalog file using the path. eg: dl filepath";
            }
            case pl: {
                return "Loads prolog file using the path. eg: pl filepath";
            }
            case s_rules: {
                return "Show loaded rules from pl and dl files";
            }
            case s_details: {
                return "Show the current loaded facts from pl and dl files";
            }
            case print: {
                return "Prints EDB and IDB values of loaded Datalog file";
            }
            case help: {
                return "Provides all available commands";
            }
            case query: {
                return "Lets user to query the database using datalog rules";
            }
            case exit: {
                return "Used to exit the program";
            }
        }
        return null;
    }

    public static Strategy getStrategy(Command command) {
        return getStrategy(command.type);
    }

    public static Strategy getStrategy(Type type) {
        switch (type) {
            case dl:
                return new DataLogLoader();
            case pl:
                return new ProLogLoader();
            case s_details:
                return new ShowDetails();
            case s_rules:
                return new ShowRules();
            case print:
                return new PrintPredicateTypes();
            case help:
                return new Help();
            case query:
                return new DatalogQuery();
            case exit:
                System.exit(0);
        }
        throw new IllegalStateException("No Command Handler found for command type: " + type);
    }

    public enum Type {
        dl,
        pl,
        s_rules,
        s_details,
        help,
        query,
        print,
        exit
    }


}
