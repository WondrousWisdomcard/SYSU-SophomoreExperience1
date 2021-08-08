package test3;

import java.io.*;
import java.net.*;

public class Server {
	public ServerSocket svrSocket = null;
	public Socket socket = null;
	public InputStream inputStream = null;
	public OutputStream outputStream = null;
	public DataInputStream dataStream = null;
	public PrintStream printStream = null;
	public DataOutputStream dataoutputStream = null;
	public String message;
	public BufferedReader charStream = new BufferedReader(new InputStreamReader(System.in));

	public Server() {
		try {
			svrSocket = new ServerSocket(1056);
			System.out.println("\nInitializint Port...");
			System.out.println("\nListen...");
			socket = svrSocket.accept();
			System.out.println("\nConnect to Client!\n");
			inputStream = socket.getInputStream();
			dataStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataoutputStream = new DataOutputStream(outputStream);

			message = dataStream.readUTF();
			System.out.println(message + "\n");
		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public void readSocket() {
		try {
			message = dataStream.readUTF();
			System.out.println(message + "\n");
			if (message.equals("Exit")) {
				System.exit(0);
			}
		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public void writeSocket() {
		try {
			String initmsg_r = new String("Enter your message: ");
			dataoutputStream.writeUTF(initmsg_r);
			System.out.print("Enter please for ready... ");
			message = charStream.readLine();
			if (!message.equals("Exit"))
				return;
			else {
				dataoutputStream.writeUTF("Exit");
				System.exit(0);
			}
		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public static void main(String args[]) {
		Server svr = new Server();
		for (;;) {
			svr.writeSocket();
			svr.readSocket();
		}
	}
}
