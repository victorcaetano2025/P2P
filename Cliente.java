import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite sua porta: ");
            int minhaPorta = Integer.parseInt(scanner.nextLine());
           
            Thread threadSever = new Thread(new Serveropener(minhaPorta));
            threadSever.start();
            System.out.println("Servidor iniciado na porta "+ minhaPorta);

            System.out.println("Digite o seu IP (caso seja na mesma maquina digite localhost): ");
            String meuIp = scanner.nextLine();

            System.out.println("Digite agora a porta que deseja conectar: ");
            int portaDestino = Integer.parseInt(scanner.nextLine());
            
            System.out.println("Tentando conectar ao IP " + meuIp + " na porta " + portaDestino + "...");
            
            Socket socket = new Socket(meuIp, portaDestino);
            System.out.println("Conexão estabelecida com sucesso!");

            Thread threadEnvio = new Thread(new ThreadEnviar(socket));
            threadEnvio.start();

            threadEnvio.join();

        } catch (NumberFormatException e) {
            System.err.println("Erro: Digite um número válido para a porta.");
        } catch (IOException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Erro ao aguardar thread: " + e.getMessage());
        }

    }
}