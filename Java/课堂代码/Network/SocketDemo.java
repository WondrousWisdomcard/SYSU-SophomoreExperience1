package test3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

class SocketDemo {
	public static void main(String args[]) {
		try {
			// Get Server and Port
			String server = args[0];
			int port = Integer.parseInt(args[1]);
			// Create socket
			Socket s = new Socket(server, port);
			// Read random number from server
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			int i = dis.readInt();
			// Display Result
			System.out.println(i);
			// Close Socket
			s.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
