package SampleCalculator;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Calculator remoteCalc =
                    (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            System.out.println("Connected to RMI Server");

            boolean exit = false;

            while (!exit) {
                // Accept two numbers
                System.out.print("Enter first number: ");
                int num1 = sc.nextInt();

                System.out.print("Enter second number: ");
                int num2 = sc.nextInt();

                // Choose operation
                System.out.println("Choose operation: 1)Sum 2)Diff 3)Product 4)Quotient 5)Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                int result = 0;

                switch (choice) {
                    case 1:
                        result = remoteCalc.sum(num1, num2);
                        System.out.println("Sum = " + result);
                        break;
                    case 2:
                        result = remoteCalc.diff(num1, num2);
                        System.out.println("Difference = " + result);
                        break;
                    case 3:
                        result = remoteCalc.prod(num1, num2);
                        System.out.println("Product = " + result);
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("Cannot divide by zero!");
                        } else {
                            result = remoteCalc.quot(num1, num2);
                            System.out.println("Quotient = " + result);
                        }
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

                System.out.println(); // Blank line for readability
            }

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
