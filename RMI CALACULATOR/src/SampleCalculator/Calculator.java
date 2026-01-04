package SampleCalculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    int sum(int a, int b) throws RemoteException;

    int diff(int a, int b) throws RemoteException;

    int prod(int a, int b) throws RemoteException;

    int quot(int a, int b) throws RemoteException;
}
