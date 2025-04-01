import java.io.*;
import java.net.*;

class Receptor implements Runnable{
    private Socket socket;

    public Receptor (Socket socket){
        this.socket=socket;
    }

    public void run(){
   
        try {
                
    (BufferedReader input =  new BufferedReader(new InputStreamReader(socket.getInputStream()))); {

    }
    }
    String mensagem;
    while((mensagem=input.readLine())!=null) {
        System.out.println("\\Mensagem recebida\\ " + mensagem);
    }
 } finally {

    try {
         socket.close(); 
    } catch (IOException e) {
        System.out.println("Fim da conexao");
    }
}
    

