package datalogQuery;

import cli.Command;
import cli.strategy.Strategy;
import datalog.DataLog;
import prolog.Prolog;

public class DatalogQuery implements Strategy {

    @Override
    public boolean run(Command command) throws Exception {
        if (command.getOptions().split(" ").length > 1) {
            throw new IllegalStateException("More options provided for query command. Example query <space> ancestor(Walter,Peter)");
        }
        Prolog.getInstance().dynamicQuery(command.getOptions());
        return false;
    }
}
