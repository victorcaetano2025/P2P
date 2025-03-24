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
            




           
            if (sms.equalsIgnoreCase("close")) {
                System.out.println("\rchat closed");
              break;
            }
            System.out.println("\rvoce digitou: "+ sms);
        }
    }
}