import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite sua porta: ");
            int minhaPorta = scanner.nextInt();
            scanner.nextLine();

            Serveropeners serveropener = new Serveropeners(minhaPorta);
            Thread threadsever = new Thread(serveropener);
            threadsever.start();

            System.out.println("Digite o seu IP (caso seja na mesma maquina digite localhost): ");
            String meuIp = scanner.nextLine();

            System.out.println("Digite agora a porta que deseja conectar: ");
            int portaDestino = scanner.nextInt();
            scanner.nextLine();

            Socket socket = new Socket(meuIp, portaDestino);
            new Thread(new ThreadEnviar(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
