package hexlet.code;

import java.util.Scanner;

class Cli {
    public static void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = input.nextLine();
        System.out.println(String.format("Hello, %s!", name));

    }
}