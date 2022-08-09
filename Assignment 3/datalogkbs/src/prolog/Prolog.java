package prolog;

import cli.CliMemory;
import com.company.lib.Clause;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Map;
import java.util.Objects;

public class Prolog {
    public static String PROLOG_FILE_PATH = "PROLOG_FILE_PATH";
    private static Prolog prolog;

    public static Prolog getInstance() {
        if (Objects.isNull(prolog)) {
            prolog = new Prolog();
        }
        return prolog;
    }

    public void consult(String filePath) {
        String consultString = String.format("consult('%s')", filePath);
        Query consultQuery = new Query(consultString);
        System.out.println(consultString + " " + (consultQuery.hasSolution() ? "Prolog File DataLogLoader Success" : "Prolog File DataLogLoader Failure"));
        if (consultQuery.hasSolution()) {
            CliMemory.getInstance().put(PROLOG_FILE_PATH, filePath);
        }
        consultQuery.close();
    }


    public void addDynamicFactsAndRules(Clause clause) {
        String assertStr = String.format("assertz((%s)).", clause);
        Query assertQuery = new Query(assertStr);
        if (assertQuery.hasSolution() && assertQuery.hasNext()) {
            System.out.printf("clause loaded into pl: %s%n", clause.toString());
        }
        assertQuery.close();
    }

    public void dynamicQuery(String command) {
        String assertStr = String.format("%s", command);
//        Variable[] variables = {new Variable("parent"), new Variable("child")};

        Query assertQuery = new Query(assertStr);
        if (assertQuery.hasSolution()) {
            Map<String, Term> result = assertQuery.oneSolution();
            if(result.size() > 0) {
                System.out.println(result);
            }
            System.out.printf("query executed successfully: %s%n", command);
        } else {
            System.out.println("No result found");
        }
        assertQuery.close();
    }
}
