package exemples;
import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {

        System.out.println("iniciando cliente");

      try (Socket socket = new Socket("127.0.0.1",4088)){
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      out.println("fala meu mano");
      
      System.out.println("sms mandado");


      } catch (Exception e) {
       e.printStackTrace();
      }  
    } 
}
