import java.io.*;
import java.net.*;

public class Client {
    private InetAddress host;
    private Socket client;
    private String name;
    public Send s;
    public Receive r;

    public Client() throws IOException {
        host = InetAddress.getLocalHost();
        client = new Socket(host.getHostName(), 9999);
        name = client.getLocalAddress().toString() + ":" + client.getLocalPort();
        System.out.println("Client->" + name);
    }

    public class Send implements Runnable {

        public void send(String message) {
            if (message.equals("") || message == null) {
                System.out.println("You can not send message with none characters.");
                return;
            }
            try {
                OutputStream os = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(name + ": " + message);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String write() {
            
            String message = null;
            System.out.print("->");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return message;
        }

        @Override
        public void run() {
            while(true){
                send(write());
            }
        }
    }

    public class Receive implements Runnable {

        public void receive() {
            try {
                InputStream is = client.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String message = dis.readUTF();

                //光标往回跑两个位置，把原来的"->"覆盖掉
                System.out.print("\r");
                System.out.println(message);
                //在下一行还原"->"
                System.out.print("->");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(true){
                receive();
            }

        }
    }   
    
    public static void main(String[] args) {
        try {
            Client c = new Client();
            new Thread(c.new Send()).start();
            new Thread(c.new Receive()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
