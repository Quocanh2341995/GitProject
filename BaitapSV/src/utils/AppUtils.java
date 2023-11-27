package utils;

import java.sql.Date;
import java.util.Scanner;

public class AppUtils {
    public static Scanner scanner = new Scanner(System.in);
    public static int getNumber (String str) {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            return num;
        } catch (Exception e) {
            System.out.println("The input data is not in the correct format");
            return getNumber(str);
        }
    }

    public static Float getScore (String str) {
        System.out.println(str);
        float num;
        try {
            num = Float.parseFloat(scanner.nextLine());
            return num;
        } catch (Exception e) {
            System.out.println("The input data is not in the correct format");
            return getScore(str);
        }
    }

    public static int getNumberMinMax(String str, int min, int max) throws IndexOutOfBoundsException {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if ( num < min || num > max) {
                System.out.println("Please choose between" + min + "and" + max);
                return getNumberMinMax(str, min, max);
            }
            return num;
        } catch (Exception e) {
            System.out.println("The input data is not in the correct format");
            return getNumberMinMax(str, min, max);
        }
    }

    public static String getString(String str) throws IndexOutOfBoundsException {
        System.out.println(str);
        return scanner.nextLine();
    }

    public static Date getDate (String str) {
        System.out.println(str);
        System.out.println("Date data type : yyyy-mm-dd");
        try {
            return Date.valueOf(scanner.nextLine());
        } catch (Exception e) {
            return getDate(str);
        }
    }

    public static String getGender (String str) {
        System.out.println(str);
        System.out.println("Enter M for Male or F for Female");
        String input = scanner.nextLine().trim().toUpperCase();
        if (input.equals("M")) {
            return "Male";
        } else if (input.equals("F")) {
            return "Female";
        } else {
            System.out.println("Invalid input!");
            return getGender(str);
        }
    }



    public static boolean getGender1 (String str) {
        System.out.println(str);
        System.out.println("Enter M for Male or F for Female");
        String input = scanner.nextLine().trim().toUpperCase();
        if (input.equals("M")) {
            return true;
        } else if (input.equals("F")) {
            return false;
        } else {
            System.out.println("Invalid input!");
            return getGender1(str);
        }
    }
}
