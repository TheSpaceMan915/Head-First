package Tests.Remote_Deployment;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemServer implements MyRemote                     //make a remote server implementation
{
    @Override
    public double doCalculations(double number)
    {
        double sum = number + 1.0;

        return sum;
    }

    public static void main(String[] args)
    {
        try
        {
            //instantiate the server
            MyRemote server_obj = new RemServer();

            //get the stub (client helper)
            MyRemote stub_obj = (MyRemote) UnicastRemoteObject.exportObject(server_obj,0);

            //create the RMI registry
            Registry registry_obj = LocateRegistry.createRegistry(1099);

            //bind the stub and the registry
            registry_obj.rebind("MyServer",stub_obj);
        }
        catch (Exception exep)
        { exep.printStackTrace(); }
    }
}
