package Tests.Remote_Deployment;
import java.rmi.Remote;
import java.rmi.RemoteException;

//make a remote interface
public interface MyRemote extends Remote {

    double doCalculations(double number) throws RemoteException;
}
