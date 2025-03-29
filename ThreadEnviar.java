import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadEnviar implements Runnable {
    private String ip;
    private int portadestino;

    public ThreadEnviar(String ip, int portadestino) {
        this.ip = ip;
        this.portadestino = portadestino;

    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(ip, portadestino);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("caso deseje sair digite 'chat_close'");
            while (true) {
                String sms = scanner.nextLine();
                output.println(sms);

                if (sms.equalsIgnoreCase("chat_close")) {
                    break;
                }

            }
            socket.close();
            scanner.close();

        } catch (Exception e) {
            System.out.println("Erro ao conectar ou enviar mensagem: " + e.getMessage());
        }

    }
}