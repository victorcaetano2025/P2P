//Abre um servidor para escutar conexões (classe Serveropener)
//Aceita conexões e recebe mensagens (classe Receptor)
//Conecta-se a outro cliente e envia mensagens (ThreadEnviar)

import java.io.IOException; //trata execoes de entrada e saida
import java.net.Socket; //permite o uso de socket
import java.util.Scanner; //permite a leitura do teclado

public class Cliente {
    public static void main(String[] args) {
        //"try" para fechar tudo apos o uso
        try (Scanner scanner = new Scanner(System.in)) { //cria um Scanner
            System.out.println("Digite sua porta: ");
            int minhaPorta = Integer.parseInt(scanner.nextLine()); //pega uma String e converte em Inteiro guardando na variavel minhaPorta
           
            Thread threadSever = new Thread(new Serveropener(minhaPorta)); //cria uma nova Thread com um parametro
            threadSever.start(); //inicia a Thread
            System.out.println("Servidor iniciado na porta "+ minhaPorta);

            System.out.println("Digite o seu IP (caso seja na mesma maquina digite localhost): ");
            String meuIp = scanner.nextLine();

            System.out.println("Digite agora a porta que deseja conectar: ");
            int portaDestino = Integer.parseInt(scanner.nextLine());
            
            System.out.println("Tentando conectar ao IP " + meuIp + " na porta " + portaDestino + "...");
            
            Socket socket = new Socket(meuIp, portaDestino); //cria um novo socket com parametros
            System.out.println("Conexão estabelecida com sucesso!");

            Thread threadEnvio = new Thread(new ThreadEnviar(socket)); //cria thread de enviar
            threadEnvio.start(); //inicia thread de enviar

            threadEnvio.join(); //faz esperar a thread atual terminar de rodar

        } catch (NumberFormatException e) { //caso seja digitado algo que nao seja numero na porta
            System.err.println("Erro: Digite um número válido para a porta.");
        } catch (IOException e) { //caso alguma thread ou socket falhem
            System.err.println("Erro ao conectar: " + e.getMessage());
        } catch (InterruptedException e) { //caso algo seja interrompido
            System.err.println("Erro ao aguardar thread: " + e.getMessage());
        }

    }
}