import java.io.BufferedReader; //usado para ler os dados do socket
import java.io.IOException; //trata execoes de entrada e saida
import java.io.InputStreamReader; //converte os bytes dos socket em texto
import java.net.Socket; //permite o uso de socket

class Receptor implements Runnable { // implementa numa Thread
    private Socket socket; // cria a variavel socket

    public Receptor(Socket socket) { // instancia a classe
        this.socket = socket;
    }

    public void run() { // chama a thread

        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // le o socket
                                                                                                          // e converte
                                                                                                          // sua leitura
                                                                                                          // para texto
            String mensagem; // variavel mensagem
            while ((mensagem = input.readLine()) != null) { // enquanto a mensagem nao for nula ira printar a mensagem
                System.out.println(mensagem);
            }
        } catch (IOException e) { // caso alguma thread ou socket falhem
            System.err.println("erro no Receptor: " + e.getMessage());
        }
    }

}
