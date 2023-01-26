
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
    Socket socket;
    BufferedReader br;
    PrintWriter out;


    public Client()
    {
        try {
            System.out.println("Sending request to server...");
            socket = new Socket("127.0.0.1", 7777); // socket obj will take server ip address and port no.

            System.out.println("Connection Done...");

            // start reading and writing through input buffer reader
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            startReading();
            startWriting();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void startReading()
    { // this thread will continue read the data..
        Runnable r1 = () -> {
            System.out.println("Reader started");
            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Server terminated the chat");
                        break;
                    }
                    System.out.println("Server : " + msg);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }; // lamda expression closed..

        new Thread(r1).start();     // thread started..
    }
    public void startWriting()
    {// this thread will continue write the data..
        Runnable r2 = () -> {
            System.out.println("writer started");
            while (true){
                try {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                }
                catch ( Exception e)
                {
                    e.printStackTrace();
                }
            }
        }; // lambda expression closed.
        new Thread(r2).start();    // thread started.
    }

    public static void main(String[] args) {
        System.out.println("This is client..");
        new Client();
    }
}