import java.io.IOException;
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
            System.out.println("aguardando alguem se conectar na porta: " + porta);
            while (true) {
                Socket conectou = server.accept();
                String ipsocket = conectou.getInetAddress().getHostAddress();
                System.out.println("Cliente conectado: " + ipsocket );

                new Thread(new Receptor(conectou)).start();
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: "+e.getMessage());

        }
    }
}