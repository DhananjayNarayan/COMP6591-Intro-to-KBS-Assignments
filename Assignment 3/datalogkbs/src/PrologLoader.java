import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrologLoader {
    public static void main(String args[]) {
        String str1 = "consult('C:/Users/madhu/MACS_Courses/Summer22/kbs/assignment_2/movie_kb_jpl/src/synonym.pl')";
        Query q1 = new Query(str1);
        System.out.println(str1 + " " + (q1.hasSolution() ? "Prolog File DataLogLoader Success" : "Prolog File DataLogLoader Failure"));
        Query q2 = new Query("get_if_common_word(CK,CC) :- findall(X, (common_keywords(X), member(X, CK)), CC).");
        String queryString = String.format("get_if_common_word([cheerful],?)");
        Variable variable = new Variable("Keywords");
        Query query = new Query(queryString, variable);
        if (query.hasSolution() && query.hasNext()) {
            Term term = query.next().get("Keywords");
            if (term.listToTermArray().length > 0) {
                System.out.println(Arrays.stream(term.listToTermArray())
                        .map(Object::toString)
                        .collect(Collectors.toList()));
            }
        }
    }
}
