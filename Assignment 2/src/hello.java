import org.jpl7.*;

import java.util.Scanner;

public class hello {
    public static void main(String[] args) {

        /**
         * To consult the knowledge base file
         */

        String str1 = "consult('C:/Users/madhu/MACS_Courses/Summer22/kbs/assignment_2/movie_kb_jpl/src/moviekb.pl')";
        Query q1 = new Query(str1);
        System.out.println(str1 + " " + (q1.hasSolution() ? "Prolog File Load Success" : "Prolog File Load Failure"));

        System.out.println("Welcome to Movie Knowledge Base!!");

        while (true) {
            System.out.println("What would you like to perform? Select one of the options below:");
            System.out.println("1. Search for a movie title\n 2. Add a movie title\n 3.Update/modify a movie title\n 4.Quit");

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            switch (input) {
                case "1":
                    /**
                     * To search for a movie title
                     */
                    String title = s.next();
//                  String str2 = String.format("find_movie(\"%s\")", title);
                    String str2 = String.format("movie(?,\"%s\",?,?,?,?,?)", title);
                    Variable[] variables = {new Variable("ID"), new Variable("Genre"),
                            new Variable("Year"), new Variable("Rating"),
                            new Variable("Keywords"), new Variable("Language")};
                    Query q2 = new Query(str2, variables);
                    System.out.println(str2 + " " + (q2.hasSolution() ? "Yes, the movie is present and below are its details" :
                            "No, the movie is not found"));
                    while (q2.hasNext()) {
                        System.out.println(q2.next());
                    }
                    break;

                case "2":
                    /**
                     * To add movie
                     */
                    System.out.println("To add a movie, Please enter the following movie details");
                    String[] movieDetails = new String[7];
                    System.out.println("Enter the movie ID");
                    movieDetails[0] = s.nextLine();
                    System.out.println("Enter the movie Title");
                    movieDetails[1] = s.nextLine();
                    System.out.println("Enter the movie Genre");
                    movieDetails[2] = s.nextLine();
                    System.out.println("Enter the movie Release Year");
                    movieDetails[3] = s.nextLine();
                    System.out.println("Enter the movie Rating");
                    movieDetails[4] = s.nextLine();
                    System.out.println("Enter the movie keywords");
                    movieDetails[5] = s.nextLine();
                    System.out.println("Enter the movie Language");
                    movieDetails[6] = s.nextLine();
                    String str3 = String.format("add_movie(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")",
                            movieDetails[0],movieDetails[1],movieDetails[2],movieDetails[3],movieDetails[4],movieDetails[5],movieDetails[6]);
                    Query q3 = new Query(str3);
                    System.out.println(str3 + " " + (q3.hasSolution() ? "Added the movie successfully" : "Couldn't add the movie"));
                    break;

                case "4":
                    System.out.println("Quitting from Knowledge Base");
                    break;
            }
        }

         /**
         * To update movie

         String str4 = "parent(walter,peter)";
         Query q4 = new Query(str2);
         System.out.println(str4 + " " + (q4.hasSolution() ? "yes" : "No walternate"));
         */
    }
}
