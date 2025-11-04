package h2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class H2_main {

    public static void main() {

        int year = 0;
        boolean isLeapYear = false;

        Scanner scanner = new Scanner(System.in);
            System.out.println("[Leap Year Calculator] Enter your year!");

            try {
                year = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[Leap Year Calculator] Invalid input!");
            }

        if(year % 4 == 0) {
            isLeapYear = true;
            if(year % 100 == 0) {
                isLeapYear = false;
            }
            if(year % 400 == 0) {
                isLeapYear = true;
            }
        }

        if(isLeapYear) {
            System.out.print("[Leap Year Calculator] Your year " + year + " is a leap year!");
        }
        else {
            System.out.print("[Leap Year Calculator] Your year " + year + " is not a leap year!");
        }
    }
}
