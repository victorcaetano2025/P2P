import java.io.IOException;
import java.net.*;

public class Connector {

    public void server(int port){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("aguardando conexao");
            while (true) {
                Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!: "+socket.getInetAddress());
                
            }

} catch (IOException e) {
            e.printStackTrace();}
}
}