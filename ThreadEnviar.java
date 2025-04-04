import java.io.IOException; //trata execoes de entrada e saida
import java.io.PrintWriter; //envia mensagens de forma mais conveniente
import java.net.Socket; //permite o uso de socket
import java.util.Scanner; //permite a leitura do teclado

public class ThreadEnviar implements Runnable { //implementa numa Thread
    private Socket socket; //cria a variavel socket

    public ThreadEnviar(Socket socket) { //instancia a classe
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in); 

            System.out.println("Para sair, digite 'chat_close'");

            while (true) {
                if (socket.isClosed()) { // Verifica se o socket ainda está aberto
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

