package cli.strategy;

import cli.Command;
import com.company.lib.Clause;
import com.company.lib.ProgramParser;
import datalog.DataLog;
import org.jpl7.Query;
import prolog.Prolog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ProLogLoader implements Strategy {

    @Override
    public boolean run(Command command) throws Exception {
        if (command.getOptions().split(" ").length > 1) {
            throw new IllegalStateException("More options provided for pl command. Example pl 'filepath'");
        }
        Prolog.getInstance().consult(command.getOptions());
        File file = new File(command.getOptions());
        InputStream targetStream = new FileInputStream(file);
        Clause[] clauses = ProgramParser.parseKB(targetStream);
        DataLog dataLog = DataLog.getInstance();
        dataLog.initiateWithDb();
        for (Clause clause : clauses) {
            if(clause.isRule()) {
                dataLog.addRules(clause);
            }
            if(clause.isProc()) {
                dataLog.addFact(clause);
            }
        }
        return false;
    }

}
