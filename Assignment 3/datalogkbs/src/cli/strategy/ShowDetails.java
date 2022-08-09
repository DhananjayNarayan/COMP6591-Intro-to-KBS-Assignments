package cli.strategy;

import cli.CliMemory;
import cli.Command;
import com.company.lib.Clause;
import datalog.DataLog;
import prolog.Prolog;

public class ShowDetails implements Strategy {

    @Override
    public boolean run(Command command) throws Exception {
        if (CliMemory.getInstance().has(Prolog.PROLOG_FILE_PATH)) {
            System.out.printf("Prolog file loaded from: %s%n",
                    CliMemory.getInstance().get(Prolog.PROLOG_FILE_PATH));
        } else {
            System.out.println("No prolog file loaded yet");
        }
        if (CliMemory.getInstance().has(DataLog.DATALOG_FILE_PATH)) {
            System.out.printf("Datalog file loaded from: %s%n",
                    CliMemory.getInstance().get(DataLog.DATALOG_FILE_PATH));
        } else {
            System.out.println("No Datalog file loaded yet");
        }
        if (DataLog.getInstance().getFacts().size() > 0) {
            System.out.println("Facts loaded are");
        } else {
            System.out.println("No facts founded inside pl or dl file");
        }
        for (Clause fact : DataLog.getInstance().getFacts()) {
            System.out.println(fact);
        }
        return false;
    }
}
