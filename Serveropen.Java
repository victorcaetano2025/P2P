import java.net.ServerSocket;
import java.net.Socket;

class Serveropener implements Runnable {

    private int porta;

    public Serveropener(int porta) {
        this.porta = porta;

    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(porta)) {
            while (true) {
                Socket conectou = server.accept();
                System.out.println("Cliente conectado: " + conectou.getInetAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}