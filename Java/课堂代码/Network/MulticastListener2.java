package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastListener2 {
	private int port;
	private String host;

	public MulticastListener2(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void listen() {
		byte[] data = new byte[256];
		try {
			InetAddress ip = InetAddress.getByName(this.host);
			MulticastSocket ms = new MulticastSocket(this.port);
			ms.joinGroup(ip);
			DatagramPacket packet = new DatagramPacket(data, data.length);
			// receive()是阻塞方法，会等待客户端发送过来的信息
			ms.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println(message);
			ms.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int port = 1234;
		String host = "230.0.0.0";
		MulticastListener ml = new MulticastListener(host, port);
		while(true)
		   ml.listen();
	}
}