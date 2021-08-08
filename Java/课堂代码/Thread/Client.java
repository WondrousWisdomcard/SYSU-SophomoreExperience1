package test3;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String args[]) {
		// Initialize the stream
		OutputStream outputStream = null;
		DataOutputStream dataoutputStream = null;
		InputStream inputStream = null;
		DataInputStream dataStream = null;
		BufferedReader charStream = null;

		// Initialize Socket
		Socket socket = null;
		String message;

		try {
			charStream = new BufferedReader(new InputStreamReader(System.in));
			message = new String("Hi! I am a client");
			socket = new Socket("127.0.0.1", 1056);
			dataStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataoutputStream = new DataOutputStream(outputStream);
			dataoutputStream.writeUTF(message);
		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}

		while (true) {
			try {
				inputStream = socket.getInputStream();
				dataStream = new DataInputStream(inputStream);
				message = dataStream.readUTF();
				System.out.print(message);
				if (message.equals("Exit")) {
					System.exit(0);
				}
				message = charStream.readLine();
				dataoutputStream.writeUTF(message);
			} catch (UnknownHostException e) {
				System.out.println("Error : Cannot find server." + e);
			} catch (IOException e) {
				System.out.println("Error : I/O Error." + e);
			}
		} // end of while
	} // end of main method
} // end of Client Constructor
