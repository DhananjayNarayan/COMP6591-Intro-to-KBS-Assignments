package cli.strategy;

import cli.CliMemory;
import cli.Command;
import com.company.lib.Clause;
import com.company.lib.ProgramParser;
import datalog.DataLog;

import java.io.*;

public class DataLogLoader implements Strategy {

    @Override
    public boolean run(Command command) throws Exception {
        if (command.getOptions().split(" ").length > 1) {
            throw new IllegalStateException("More options provided for dl command. Example dl 'filepath'");
        }
        File file = new File(command.getOptions());
        InputStream targetStream = new FileInputStream(file);
        Clause[] clauses = ProgramParser.parseKB(targetStream);
        DataLog dataLog = DataLog.getInstance();
        CliMemory.getInstance().put(DataLog.DATALOG_FILE_PATH, command.getOptions());
        for (Clause clause : clauses) {
            dataLog.add(clause);
        }
        System.out.printf("%d facts found in datalog%n", dataLog.getFacts().size());
        System.out.printf("%d rules found in datalog%n", dataLog.getRules().size());
        return false;
    }
}
