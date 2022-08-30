package Chat_App;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    private Socket m_sock;
    private BufferedReader m_reader;
    private PrintWriter m_writer;


    public class MessageReceiver implements Runnable
    {
        @Override
        public void run()                   //the client receives messages from the server and at the same time
        {                                   //he is able to send new messages to the server
            String message = "";
            try
            {
                while ((message = m_reader.readLine()) !=null)
                {
                    JTextArea text_area = GUI.getTextArea();
                    text_area.append(message + "\n");
                }
            }
            catch (IOException exep)
            { exep.printStackTrace(); }
        }
    }

    public ChatClient(String id, int tcp)
    {
        try
        {
            m_sock = new Socket(id,tcp);

            InputStreamReader stream = new InputStreamReader(m_sock.getInputStream());
            m_reader = new BufferedReader(stream);
            m_writer = new PrintWriter(m_sock.getOutputStream());

            Thread thread = new Thread(new MessageReceiver());
            thread.start();
        }
        catch (IOException exep)
        { exep.printStackTrace(); }
    }

    public BufferedReader getReader() { return m_reader; }

    public PrintWriter getWriter() { return m_writer; }

    public static void main(String[] args) {

    }
}
