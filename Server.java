
import java.net.*;
import java.io.*;

class Server {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    // Server constructor.....
    public Server() {
        try {
            server = new ServerSocket(7777); // 7777 is port no

            System.out.println("Server is ready to accept connection...");
            System.out.println("Waiting for connection..");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            startReading();
            startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // function for reading msg...

    public void startReading()
    { 
    // this thread will continue read the data.
        Runnable r1 = () -> {    // lamda expression ...

            System.out.println("Reader started");
            while (true) {
                try {
                    String msg = br.readLine();
                    if (msg.equals("exit"))
                    {
                        System.out.println("Client terminated the chat");
                        break;
                    }
                    System.out.println("Client : " + msg);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        new Thread(r1).start();
    }

    // function for writing msg

    public void startWriting()
    {
    	// this thread will continue writing the data.

        Runnable r2 = () -> {   // lamda expression..

            System.out.println("writer started");
            while(true)
            {
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
        };

        new Thread(r2).start(); 
    }

    public static void main (String [] args)
    {
        System.out.println("This is server going to start...");
        new Server(); // creating server obj to call the constructor of server.
    }
}