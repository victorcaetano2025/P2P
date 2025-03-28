package P2P_real;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[]args) throws IOException{
        try {
            
       ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();
        System.out.println("Entrou");

        InputStreamReader Streamreader = new InputStreamReader(socket.getInputStream());
        PrintStream saida = new PrintStream(socket.getOutputStream());
        BufferedReader BufferedReader = new BufferedReader(Streamreader);

        String x;
        while ((x = BufferedReader.readLine()) != null) {
            saida.println ("Mensagem recebida: " +x); 
        }
    } catch (Exception e) {
       
    }
    }
}
