import java.io.IOException; //trata execoes de entrada e saida
import java.net.ServerSocket; //permite utilizar serverSocket
import java.net.Socket; //permite o uso de socket

class Serveropener implements Runnable { // implementa numa Thread

    private int porta; // cria uma variavel porta

    public Serveropener(int porta) { // instancia a classe
        this.porta = porta;

    }

    @Override // ajuda a avisar erros e sobrescrever metodos
    public void run() { // chama a thread
        // "try" para fechar tudo apos o uso e tratar execoes
        try (ServerSocket server = new ServerSocket(porta)) { // cria um novo server
            System.out.println("aguardando alguem se conectar na porta: " + porta);
            while (true) {
                Socket conectou = server.accept(); // bloqueia ate se conectar

                new Thread(new Receptor(conectou)).start(); // permite que continue acietando conexoes
            }
        } catch (IOException e) { // caso alguma thread ou socket falhem
            System.err.println("Erro no servidor: " + e.getMessage());

        }
    }
}