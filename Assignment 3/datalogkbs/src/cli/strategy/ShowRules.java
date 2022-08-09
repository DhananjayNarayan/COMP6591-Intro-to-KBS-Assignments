package cli.strategy;

import cli.Command;
import com.company.lib.Clause;
import datalog.DataLog;

public class ShowRules implements Strategy {

    @Override
    public boolean run(Command command) throws Exception {
        DataLog dataLog = DataLog.getInstance();
        for (Clause clause : dataLog.getRules()) {
            System.out.println(clause.getHead());
        }
        return false;
    }
}
