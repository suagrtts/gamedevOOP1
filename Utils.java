package game;

import java.util.Scanner;

public class Utils {
    public static int readInt(Scanner scanner, int min, int max) {
        int input = -1;
        do {
            System.out.print("> ");
            while (!scanner.hasNextInt()) {
                System.out.print("> ");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }
}