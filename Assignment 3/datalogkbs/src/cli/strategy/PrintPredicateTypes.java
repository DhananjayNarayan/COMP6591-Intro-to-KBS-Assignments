package cli.strategy;

import cli.CliMemory;
import cli.Command;
import com.company.lib.Clause;
import com.company.lib.ProgramParser;
import datalog.DataLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintPredicateTypes implements Strategy {
    @Override
    public boolean run(Command command) throws Exception {
        if (!CliMemory.getInstance().has(DataLog.DATALOG_FILE_PATH)) {
            throw new IllegalAccessException("No DataLog file loaded to print IDB and EDB data");
        }
        String filePath = CliMemory.getInstance().get(DataLog.DATALOG_FILE_PATH);
        File file = new File(filePath);
        InputStream targetStream = new FileInputStream(file);
        List<Clause> clauses = Arrays.stream(ProgramParser.parseKB(targetStream)).filter(Clause::isRule).collect(Collectors.toList());
        Set<String> IDB = new HashSet<>();
        for (Clause clause : clauses) {
            IDB.add(clause.getHead().getName());
        }
        Set<String> EDB = clauses.stream()
                .flatMap(clause -> Arrays.stream(clause.getGoals()))
                .map(Clause::getName)
                .filter(name -> !IDB.contains(name))
                .collect(Collectors.toSet());
        System.out.printf("Available IDBs: %s%n", String.join(",", IDB));
        System.out.printf("Available EDBs: %s%n", String.join(",", EDB));
        return false;
    }
}
