package P2P_real;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[]args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();

        InputStreamReader Streamreader = new InputStreamReader(socket.getInputStream());
        BufferedReader Buffered = new BufferedReader(Streamreader);

        String x;
        while ((x = Buffered.readLine()) != null) {
            System.out.println("Mensagem recebida: " +x); 
        }
    }
}
