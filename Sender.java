import java.util.Scanner;

class Sender extends Thread {
private Scanner entrada;

public Sender(Scanner entrada){
    this.entrada = entrada;
}
    public void run() {
       System.out.println("chat open");
        while (true) {
           String sms = entrada.nextLine();
            




           
            if (sms.equalsIgnoreCase("chatclose")) {
                System.out.println("\rchat closed");
                System.exit(0);
            }
            System.out.println("\rvoce digitou: "+ sms);
        }
    }
}
