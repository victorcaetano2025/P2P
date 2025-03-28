package P2P_real;

import java.net.Socket;

public class Client {
    public static void main(String[]args){

        try {
            
            Socket socket = new Socket("localhost", 8081);

        } catch (Exception e) {
           
        }
    }
}
