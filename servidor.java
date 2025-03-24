import java.io.*;
import java.net.*;

public class servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4088)) {
            System.out.println("Servidor aguardando conexões...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado! "+socket.getInetAddress());

            // Criando InputStream para ler a mensagem do cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensagem = in.readLine();
            System.out.println("Mensagem recebida: " + mensagem);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
