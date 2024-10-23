package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int lastResult = 0;
        System.out.println("Welcome. ");
        
        while (true) {

            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("Bye.");
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length != 3) {
                System.out.println("Invalid");
                continue;
            }

            int num1;
            int num2;

            try{
                if (parts[0].equals("$last")) {
                    num1 = lastResult;
                } else {
                    num1 = Integer.parseInt(parts[0]);
                }

                if (parts[2].equals("$last")) {
                    num2 = lastResult;
                } else {
                    num2 = Integer.parseInt(parts[2]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid");
                continue;
            }

            String operator = parts[1];

            int result = 0;
            switch(operator) {
                case "+":
                result = num1 + num2;
                break;

                case "-":
                result = num1 - num2;
                break;

                case "*":
                result = num1 * num2;
                break;

                case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot be divded by zero.");
                    continue;
                }

                break;

                default:
                System.out.println("Invalid.");
                continue;
            }

            System.out.println(result);
            lastResult = result;

        }

        scanner.close();

    }
}