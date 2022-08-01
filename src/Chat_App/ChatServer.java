package Chat_App;
import java.io.*;
import java.net.*;
import java.util.*;

/*Starting order:
1. ChatServer
2. ChatDriver
3. GUI
*/

public class ChatServer {

    private final static List<PrintWriter> m_arr_client_writers = new ArrayList<>();       //write messages FROM the server TO clients

    //get messages from clients
    private static class ClientHandler implements Runnable
    {
        private BufferedReader m_reader;

        public ClientHandler(Socket sock)
        {
            try
            {
                Socket client_sock = sock;
                InputStreamReader stream = new InputStreamReader(sock.getInputStream());
                m_reader = new BufferedReader(stream);
            }
            catch (IOException exep)
            { exep.printStackTrace(); }
        }

        @Override
        public void run()
        {
            String mess = "";

            //read a message from the client and send that message to every other client
            try
            {
                while ((mess = m_reader.readLine()) != null)
                { sendMessage(mess); }
            }
            catch (IOException exep)
            { exep.printStackTrace(); }
        }
    }

    private static void sendMessage(String message)
    {
        m_arr_client_writers.forEach(writer ->
        {
            writer.println(message);
            writer.flush();
        });
    }

    public void connectClients()
    {
        try
        {
            ServerSocket server_sock = new ServerSocket(4242);

            while (true)
            {
                Socket client_sock = server_sock.accept();
                PrintWriter writer = new PrintWriter(client_sock.getOutputStream());
                m_arr_client_writers.add(writer);

                //create a thread for the connected client
                Thread thread_obj = new Thread(new ClientHandler(client_sock));
                thread_obj.start();
            }
        }
        catch (Exception exep)
        { exep.printStackTrace(); }
    }

    public static void main(String[] args)
    {
        ChatServer server = new ChatServer();
        server.connectClients();
    }
}
