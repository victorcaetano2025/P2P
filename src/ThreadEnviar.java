import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.Socket;
import java.util.Scanner; 

public class ThreadEnviar implements Runnable {
    private Socket socket; 

    public ThreadEnviar(Socket socket) { 
        this.socket = socket;
    }

    @Override 
    public void run() { 
        try {

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); 
                                                                                  
            Scanner scanner = new Scanner(System.in); 

            System.out.println("Para sair, digite 'chat_close'");
            output.println("Usuario conectado: " + socket.getInetAddress().getHostName());

            while (true) {
                if (socket.isClosed()) { 
                    System.out.println("Conexão foi encerrada.");
                    break;
                }
                String sms = scanner.nextLine(); 
                output.println(socket.getInetAddress().getHostName() + ": " + sms); 

                if (sms.equalsIgnoreCase("chat_close")) { 
                    output.println(socket.getInetAddress().getHostName() + " encerrou o chat.");
                    break;
                }
            }

            output.close(); 
            scanner.close(); 
            socket.close(); 

        } catch (IOException e) { 
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
