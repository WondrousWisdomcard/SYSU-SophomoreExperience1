import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private List<ConnectedClient> clients = new ArrayList<ConnectedClient>();

    public class ConnectedClient implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;


        public ConnectedClient(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String receive() {
            String message = null;
            try {
                message = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return message;
        }

        public void send(String message) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                String mes = receive();
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i) != null && clients.get(i) != this) {
                            clients.get(i).send(mes);
                        }
                    }
            }
        }
    }

    public void start() throws InterruptedException, IOException {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("Error in Creating ServerSocket");
            e.printStackTrace();
        }

        Thread.sleep(500);
        System.out.println("Server -> java server");
        Thread.sleep(500);
        System.out.println("Initializing Port...");
        Thread.sleep(500);
        System.out.println("Listening...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Connect to client: " + client.getInetAddress() + ":" + client.getPort());
            ConnectedClient connectedClient = new ConnectedClient(client);
            clients.add(connectedClient);
            new Thread(connectedClient).start();
        }
    }

    public static void main(String[] args) {
        try {
            Server s = new Server();
            s.start();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
