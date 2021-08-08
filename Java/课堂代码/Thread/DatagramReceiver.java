package test3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class DatagramReceiver {
	  private final static int BUFSIZE = 20;
	  public static void main(String args[]) {
	    try {
	      //Obtain port
	      int port = Integer.parseInt(args[0]);

	      //Create a DatagramSocket object for the port
	      DatagramSocket ds = new DatagramSocket(port); 

	      //Create a buffer to hold incoming data
	      byte buffer[] = new byte[BUFSIZE]; 

	      //Create infinite loop
	      while(true) {
	        //Create a datagram packet
	        DatagramPacket dp = 
	          new DatagramPacket(buffer, buffer.length);

	        //Receive data
	        ds.receive(dp); 

	        //Get data from the datagram packet
	        String str = new String(dp.getData());
	        
	        // Display the data
	        System.out.println(str);
	      }
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}
