package P2P_real;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[]args){

        try {
            
            Socket socket = new Socket("localhost", 8081);
            Scanner scanner = new Scanner(System.in);
            
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            PrintStream saida = new PrintStream(socket.getOutputStream());
            String teclado = scanner.nextLine();
            saida.println(teclado);

        } catch (Exception e) {
           
        }
    }
}
