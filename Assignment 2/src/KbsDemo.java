import org.jpl7.*;

import java.util.Scanner;

public class KbsDemo {

    private final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        KbsDemo demo = new KbsDemo();
        demo.init();
        demo.close();
    }

    private void close() {
        s.close();
    }

    public void init() {
        loadDb();
        System.out.println("Welcome to Movie Knowledge Base!!");
        showOptions();
    }

    /**
     * To consult the knowledge base file
     */
    public void loadDb() {
        String loadQueryString = "consult('C:/Users/madhu/MACS_Courses/Summer22/kbs/kbs-assignments/Assignment 2/src/moviekb.pl')";
        Query loadQuery = new Query(loadQueryString);
        System.out.println(loadQueryString + " " + (loadQuery.hasSolution() ? "Prolog File Load Success" : "Prolog File Load Failure"));
    }

    public void showOptions() {
        System.out.println("What would you like to perform? Select one of the options below:");
        System.out.println("\n " +
                "1. Search for a movie title\n " +
                "2. Add a movie title\n " +
                "3. Update/modify a movie title\n " +
                "4. Quit");
        String input = s.nextLine();
        switch (input) {
            case "1":
                findMovie();
                showOptions();
                return;

            case "2":
                addMovie();
                showOptions();
                return;

            case "3":
                System.out.println("Enter the movie id for which the title has to be changed:");
                String movieID = s.nextLine();
                updateMovie(movieID);
                showOptions();
                return;
            case "4":
                System.out.println("Quitting from Knowledge Base");
                return;
        }
        System.out.println("Select valid options from the list");
        showOptions();
    }

    /**
     * To search for a movie title
     */
    private void findMovie() {
        String title = getInput("Enter the movie title to search...");
        String str2 = String.format("find_a_movie('%s',?)", title);
        Variable variables = new Variable("Movies");
        Query q2 = new Query(str2, variables);
        if (q2.hasSolution() && q2.hasNext()) {
            Term term = q2.next().get("Movies");
            if (term.listToTermArray().length > 0) {
                System.out.println(str2 + " Yes, the movie is present and below are its details");
                System.out.println(term);
                return;
            }
        }
        System.out.println(str2 + " No, the movie is not found");
    }

    /**
     * To add movie
     */
    private void addMovie() {
        System.out.println("To add a movie, Please enter the following movie details");
        String[] movieDetails = new String[7];
        movieDetails[0] = getInput("Enter the movie ID");
        movieDetails[1] = getInput("Enter the movie Title");
        movieDetails[2] = getInput("Enter the movie Genre");
        movieDetails[3] = getInput("Enter the movie Release Year");
        movieDetails[4] = getInput("Enter the movie Rating");
        movieDetails[5] = getInput("Enter the movie keywords");
        movieDetails[6] = getInput("Enter the movie Language");
        String str3 = String.format("add_movie('%s','%s','%s','%s','%s',[%s],[%s])",
                movieDetails[0], movieDetails[1], movieDetails[2], movieDetails[3],
                movieDetails[4], movieDetails[5], movieDetails[6]);
        Query q3 = new Query(str3);
        System.out.println(str3 + " " + (q3.hasSolution() ? "Added the movie successfully" : "Couldn't add the movie"));
    }

    /**
     * To update movie details
     */
    public void updateMovie(String movieID) {
        System.out.printf("Which of the below details you want to update for the movie with id '%s'? Select one option below:\n", movieID);
        System.out.println("\n " +
                "1. movie title\n " +
                "2. movie genre\n " +
                "3. movie rating\n " +
                "4. movie year\n " +
                "5. movie keywords\n " +
                "6. movie languages\n " +
                "7. Exit update");
        String option = s.nextLine();
        switch (option) {
            case "1":
                String newTitle = getInput("Enter the movie's new title:");
                String upd1 = String.format("update_movie_title('%s','%s')", movieID, newTitle);
                Query updQ1 = new Query(upd1);
                System.out.println(upd1 + " " + (updQ1.hasSolution() ? "movie title is updated successfully" : "Couldn't update movie ID"));
                updateMovie(movieID);
                return;
            case "2":
                String newGenre = getInput("Enter the movie's new genre:");
                String upd2 = String.format("update_movie_genre('%s','%s')", movieID, newGenre);
                Query updQ2 = new Query(upd2);
                System.out.println(upd2 + " " + (updQ2.hasSolution() ? "movie genre is updated successfully" : "Couldn't update movie genre"));
                updateMovie(movieID);
                return;
            case "3":
                String newRating = getInput("Enter the movie's new rating:");
                String upd3 = String.format("update_movie_rating('%s','%s')", movieID, newRating);
                Query updQ3 = new Query(upd3);
                System.out.println(upd3 + " " + (updQ3.hasSolution() ? "movie rating is updated successfully" : "Couldn't update movie rating"));
                updateMovie(movieID);
                return;
            case "4":
                String newYear = getInput("Enter the movie's new year:");
                String upd4 = String.format("update_movie_year('%s','%s')", movieID, newYear);
                Query updQ4 = new Query(upd4);
                System.out.println(upd4 + " " + (updQ4.hasSolution() ? "movie year is updated successfully" : "Couldn't update movie year"));
                updateMovie(movieID);
                return;
            case "5":
                String newKeywords = getInput("Enter the movie's new keywords as comma separated values:");
                String upd5 = String.format("update_movie_keywords('%s',[%s])", movieID, newKeywords);
                Query updQ5 = new Query(upd5);
                System.out.println(upd5 + " " + (updQ5.hasSolution() ? "movie keywords are updated successfully" : "Couldn't update movie keywords"));
                updateMovie(movieID);
                return;
            case "6":
                String newLang = getInput("Enter the movie's new language:");
                String upd6 = String.format("update_movie_languages('%s',[%s])", movieID, newLang);
                Query updQ6 = new Query(upd6);
                System.out.println(upd6 + " " + (updQ6.hasSolution() ? "movie language is updated successfully" : "Couldn't update movie language"));
                updateMovie(movieID);
                return;
            case "7":
                System.out.println("Exiting from update function");
                return;
        }
        System.out.println("Select valid options from the list");
        updateMovie(movieID);
    }

    public String getInput(String display) {
        System.out.println(display);
        return s.nextLine();
    }
}
