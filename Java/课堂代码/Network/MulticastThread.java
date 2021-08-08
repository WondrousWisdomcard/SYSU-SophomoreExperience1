import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastThread extends Thread {
    private String groupIP;
    private int port;
    private int id;

    public MulticastThread(int id){
        this.groupIP = "230.0.0.0";
        this.port = 4321;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            // create InetAddress
            InetAddress group = InetAddress.getByName(this.groupIP);
            // create MulticastSocket
            MulticastSocket ms = new MulticastSocket(port);
            ms.joinGroup(group);
            // the package it send will loop back to itself
            ms.setLoopbackMode(false);

            // wait for other members
            Thread.sleep(3000);

            // send a package to other members
            String message = "Hello, I am User " + String.valueOf(this.id) + ".";
            byte[] buffer = message.getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length,group,port);
            ms.send(dp);

            // receive packages from other members
            buffer = new byte[8192];
            dp = new DatagramPacket(buffer, buffer.length);
            ms.receive(dp);
            String s = new String(dp.getData(),0,dp.getLength());
            System.out.println("User " + String.valueOf(this.id) + " receive :" + s);

            buffer = new byte[8192];
            dp = new DatagramPacket(buffer, buffer.length);
            ms.receive(dp);
            s = new String(dp.getData(),0,dp.getLength());
            System.out.println("User " + String.valueOf(this.id) + " receive :" + s);

            buffer = new byte[8192];
            dp = new DatagramPacket(buffer, buffer.length);
            ms.receive(dp);
            s = new String(dp.getData(),0,dp.getLength());
            System.out.println("User " + String.valueOf(this.id) + " receive :" + s);

            // leave group and close the socket
            ms.leaveGroup(group);
            ms.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
