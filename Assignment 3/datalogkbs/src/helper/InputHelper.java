package helper;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scanner = new Scanner(System.in);

    public static String getInputUsingVariables(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (String s : array) {
            sb.append(s);
            System.out.printf("Input variable for %s%n", s);
            String input = scanner.nextLine();
            sb.append("=").append(input).append(";");
        }
        String variables = sb.toString().replaceAll(";", "&");
        return variables.substring(0, variables.length() - 1);
    }

    public static String getUserInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
