package SampleCalculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    public int diff(int a, int b) throws RemoteException {
        return a - b;
    }

    public int prod(int a, int b) throws RemoteException {
        return a * b;
    }

    public int quot(int a, int b) throws RemoteException {
        if (b == 0)
            throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}
