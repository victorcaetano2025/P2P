package P2P_real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            
        InputStreamReader Streamreader = new InputStreamReader(socket.getInputStream());
        BufferedReader BufferedReader = new BufferedReader(Streamreader);

        String x;
        while ((x = BufferedReader.readLine()) != null) {
            System.out.println("Cliente: " + x);
        }
        } catch (Exception e) {
            
        }
           
    }
}
