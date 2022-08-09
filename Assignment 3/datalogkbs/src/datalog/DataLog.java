package datalog;

import com.company.lib.Clause;
import prolog.Prolog;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DataLog {

    public static final String DATALOG_FILE_PATH = "DATALOG_FILE_PATH";
    private static DataLog datalog;
    private final Set<Clause> facts;
    private final Set<Clause> rules;

    private DataLog() {
        facts = new HashSet<>();
        rules = new HashSet<>();
    }

    public void addFact(Clause clause) {
        facts.add(clause);
    }

    public void addRules(Clause clause) {
        rules.add(clause);
    }

    public void add(Clause clause) {
        if (clause.isRule()) {
            addRules(clause);
        }
        if (clause.isProc()) {
            addFact(clause);
        }
    }

    public static DataLog getInstance() {
        if (Objects.isNull(DataLog.datalog)) {
            datalog = new DataLog();
        }
        return datalog;
    }


    public void initiateWithDb() {
        loadFactsToDb();
        loadRulesToDb();
    }

    public void loadFactsToDb() {
        Prolog prolog = Prolog.getInstance();
        for (Clause fact : facts) {
            prolog.addDynamicFactsAndRules(fact);
        }
    }

    public void loadRulesToDb() {
        Prolog prolog = Prolog.getInstance();
        for (Clause rule : rules) {
            prolog.addDynamicFactsAndRules(rule);
        }
    }

    public Set<Clause> getFacts() {
        return this.facts;
    }

    public Set<Clause> getRules() {
        return this.rules;
    }
}
