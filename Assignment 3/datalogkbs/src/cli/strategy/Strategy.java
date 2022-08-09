package cli.strategy;

import cli.Command;

public interface Strategy {
    boolean run(Command command) throws Exception;
}
