import java.io.IOException; //trata execoes de entrada e saida
import java.io.PrintWriter; //envia mensagens de forma mais conveniente
import java.net.Socket; //permite o uso de socket
import java.util.Scanner; //permite a leitura do teclado

public class ThreadEnviar implements Runnable { // implementa numa Thread
    private Socket socket; // cria a variavel socket

    public ThreadEnviar(Socket socket) { // instancia a classe
        this.socket = socket;
    }

    @Override // ajuda a avisar erros e sobrescrever metodos
    public void run() { // chama a thread
        try {

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // pega a mensagem e converte de forma
                                                                                  // legivel e clara para enviar
            Scanner scanner = new Scanner(System.in); // cria um novo Scanner

            System.out.println("Para sair, digite 'chat_close'");
            output.println("Usuario conectado: " + socket.getInetAddress().getHostName());

            while (true) {
                if (socket.isClosed()) { // Verifica se o socket ainda está aberto
                    System.out.println("Conexão foi encerrada.");
                    break;
                }
                String sms = scanner.nextLine(); // le a mensagem do teclado
                output.println(socket.getInetAddress().getHostName() + ": " + sms); // envia pro outro cliente

                if (sms.equalsIgnoreCase("chat_close")) { // se digitar chatclose ele para
                    output.println(socket.getInetAddress().getHostName() + " encerrou o chat.");
                    break;
                }
            }

            output.close(); // fecha o envio de mensagens
            scanner.close(); // fecha a leitura
            socket.close(); // fecha o socket

        } catch (IOException e) { // caso alguma thread ou socket falhem
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
