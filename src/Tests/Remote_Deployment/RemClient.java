package Tests.Remote_Deployment;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemClient
{

    public static void main(String[] args)
    {
        try
        {
            //get the RMI registry
            Registry registry = LocateRegistry.getRegistry();

            //get the stub (client helper) from the registry
            MyRemote stub_obj = (MyRemote) registry.lookup("MyServer");

            //call the method
            double res = stub_obj.doCalculations(4.0);
            System.out.println(res);
        }
        catch (Exception exep)
        { exep.printStackTrace(); }
    }
}
