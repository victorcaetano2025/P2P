import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Digite sua porta: ");
        int minhaPorta=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Deseja se conectar a outro cliente? s/n");
        String resposta=scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")){
            System.out.println("Digite o seu IP (caso seja na mesma maquina digite localhost): ");
            String Ip=scanner.nextLine();

            System.out.println("Digite agora a porta que deseja conectar: ");
            int porta=scanner.nextInt();
            scanner.nextLine();
        }

    

    }
}
