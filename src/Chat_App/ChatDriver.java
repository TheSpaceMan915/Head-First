package Chat_App;

public class ChatDriver
{
    private final static ChatClient m_client = new ChatClient("127.0.0.1",4242);


    public static ChatClient getClient() { return m_client; }

    public static void main(String[] args)
    {


    }
}
