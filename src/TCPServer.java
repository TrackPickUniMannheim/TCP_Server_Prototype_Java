import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The class extends the Thread class so we can receive and send messages at the same time
 */
public class TCPServer extends Thread {

    public static final int SERVERPORT = 9999;
    

    public static void main(String[] args) {
    	ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(SERVERPORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
            	System.out.println("Listening...");
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new TCPThread(socket).start();
        }
    }

    

}