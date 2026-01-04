package SampleCalculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMain {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            CalculatorImpl calc = new CalculatorImpl();

            Naming.rebind("rmi://localhost/CalculatorService", calc);

            System.out.println("Calculator RMI Server is running...");
        }
        catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
