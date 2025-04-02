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
        try{

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("caso deseje sair digite 'chat_close'");

            while (true) {
                String sms = scanner.nextLine();
                output.println(sms);

                if (sms.equalsIgnoreCase("chat_close")) {
                    output.println(socket.getInetAddress()+" encerrou chat");
                    break;
                }

            }
            socket.close();
            scanner.close();

        } catch (IOException e) { // Mudança para IOException
            System.out.println("Erro ao conectar ou enviar mensagem: " + e.getMessage());
            e.printStackTrace();
        }

    }
}