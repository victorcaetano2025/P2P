public class P2P {
    public static void main(String[] args) {
        Connector conn = new Connector();
        System.out.println("new feito");
        conn.server(4088);
        Sender mensageiro = new Sender("127.0.0.2",4089);
        mensageiro.start();
    }
}
