package test3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class DatagramSender {
	  public static void main(String args[]) {
	    try  {
	      // Create destination Internet address
	      InetAddress ia = 
	        InetAddress.getByName(args[0]);
	      // Obtain destination port
	      int port = Integer.parseInt(args[1]);

	      // Create a datagram socket
	      DatagramSocket ds = new DatagramSocket(); 

	      //Create a datagram packet
	      byte buffer[] = args[2].getBytes();
	      DatagramPacket dp = 
	        new DatagramPacket(buffer, buffer.length, 
	          ia, port); 
	      // Send the datagram packet
	      ds.send(dp);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
