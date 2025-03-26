import java.net.Socket;
import java.util.Scanner;

class Sender extends Thread {
private int port;
private String ip;

public Sender(int port,String ip){
    this.ip = ip;
    this.port = port;
}

    public void run() {
        try(
            Socket socket = new Socket(ip,port);
            Scanner scanner = new Scanner(System.in);
            
        ){
            System.out.println("chat open");

            while (true) {   
                String mensagem = scanner.nextLine();
            socket.getOutputStream();
                
           
                if (mensagem.equalsIgnoreCase("chatclose")) {
                    System.out.println("\rchat closed");
                    System.exit(0);
                }
                System.out.println("\rvoce digitou: "+ mensagem);
            }
        }catch (Exception e) {
           e.printStackTrace();
        }
    }
}
