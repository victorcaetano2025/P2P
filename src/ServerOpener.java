import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 

class ServerOpener implements Runnable { 

    private int porta; 

    public ServerOpener(int porta) { 
        this.porta = porta;

    }

    @Override 
    public void run() { 
        
        try (ServerSocket server = new ServerSocket(porta)) { 
            System.out.println("aguardando alguem se conectar na porta: " + porta);
            while (true) {
                Socket conectou = server.accept(); 
                new Thread(new ThreadReceptor(conectou)).start(); 
            }
        } catch (IOException e) { 
            System.err.println("Erro no servidor: " + e.getMessage());

        }
    }
}