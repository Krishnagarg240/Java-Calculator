package calculator;

import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== JAVA CALCULATOR =====");
            System.out.println("1. Perform Calculation");
            System.out.println("2. View History");
            System.out.println("3. Clear History");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter first number: ");
                    double a = sc.nextDouble();

                    System.out.print("Enter operator (+, -, *, /): ");
                    char op = sc.next().charAt(0);

                    System.out.print("Enter second number: ");
                    double b = sc.nextDouble();

                    double result = 0;
                    boolean valid = true;

                    switch (op) {

                        case '+':
                            result = a + b;
                            break;

                        case '-':
                            result = a - b;
                            break;

                        case '*':
                            result = a * b;
                            break;

                        case '/':
                            if (b != 0) {
                                result = a / b;
                            } else {
                                System.out.println("Cannot divide by zero!");
                                valid = false;
                            }
                            break;

                        default:
                            System.out.println("Invalid operator!");
                            valid = false;
                    }

                    if (valid) {
                        System.out.println("Result = " + result);

                        String entry = a + " " + op + " " + b + " = " + result;
                        history.add(entry);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Calculation History ---");

                    if (history.isEmpty()) {
                        System.out.println("No calculations yet!");
                    } else {
                        for (String entry : history) {
                            System.out.println(entry);
                        }
                    }
                    break;

                case 3:
                    history.clear();
                    System.out.println("History cleared!");
                    break;

                case 4:
                    System.out.println("Calculator closed!");
                    break;

                default:
                    System.out.println("Invalid menu choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}