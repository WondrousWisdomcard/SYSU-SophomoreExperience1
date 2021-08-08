package test3;

import java.io.*;
import java.net.*;
import java.util.*;

class ServerSocketDemo {
	public static void main(String args[]) {
		try {

			// Get Port
			int port = Integer.parseInt(args[0]);
			Random random = new Random();
			// Create Server Socket
			ServerSocket ss = new ServerSocket(port);
			// Create Infinite Loop
			while (true) {
				// Accept Incoming Requests
				Socket s = ss.accept();

				// Write Result to Client
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(random.nextInt());
				// Close socket
				s.close();
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
