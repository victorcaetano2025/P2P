import java.io.*;
import java.net.*;

class Receptor implements Runnable {
    private Socket socket;

    public Receptor(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensagem;
            while ((mensagem = input.readLine()) != null) {
                System.out.println(socket.getInetAddress() + ": " + mensagem);
            }
        } catch (Exception e) {
            System.out.println("erro no Receptor");
            e.printStackTrace();
        }
    }

}
