import java.io.*; //importacoes asddqrqwred
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); //ler as mensagens do teclado
    
        System.out.println("Digite sua porta: ");
        int minhaPorta=scanner.nextInt();
        scanner.nextLine(); //proxima leitura

        System.out.println("Deseja se conectar a outro cliente? s/n");
        String resposta=scanner.nextLine();

        Socket socket=null; //socket comeca sem nada
       
        try {
            System.out.println("asd");
            
        if (resposta.equalsIgnoreCase("s")){ //condicional
            System.out.println("Digite o seu IP (caso seja na mesma maquina digite localhost): ");
            String Ip=scanner.nextLine(); //define a variavel e ler com o scanner

            System.out.println("Digite agora a porta que deseja conectar: ");
            int porta=scanner.nextInt(); //define a variavel e ler com o scanner
            scanner.nextLine();
               
            ThreadEnviar enviarei = new ThreadEnviar(Ip, porta);
            Thread thread = new Thread(enviarei);
            thread.start();
        }

        else {
            ServerSocket serverSocket = new ServerSocket(minhaPorta); //condicional
            System.out.println("Voce esta esperando na porta: " + minhaPorta);

            socket = serverSocket.accept(); //permite conexao
            System.out.println("Conexao aceita");
        }
    } catch (IOException e) {
        System.out.println("erro ao conectar ou com o servidor"); // Falha ao conectar a um servidor remoto. 
                                                                    //  Problemas de comunicação via HTTP, sockets, ou streams de entrada/saída.
        
        
    }
        new Thread (new Receptor (socket)).start(); //incia a Thread com o start

       
    }
}
