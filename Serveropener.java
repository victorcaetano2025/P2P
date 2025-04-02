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

                Receptor receptor = new Receptor(conectou);
                Thread threadReceptor = new Thread(receptor);
                threadReceptor.start();
            }
        } catch (Exception e) {
            System.out.println("erro no servidor");
            e.printStackTrace();

        }
    }
}