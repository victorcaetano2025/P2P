import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Receptor implements Runnable {
    private Socket socket;

    public Receptor(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String mensagem;
            while ((mensagem = input.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException e) {
            System.err.println("erro no Receptor: "+e.getMessage());
        }
    }

}
