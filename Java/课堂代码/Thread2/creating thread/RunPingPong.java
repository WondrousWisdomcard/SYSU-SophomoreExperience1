package test6;

public class RunPingPong implements Runnable {
	 private String word;
	 private int delay;
	 public RunPingPong(String whatToSay, int delayTime) {
	   word = whatToSay;
	   delay = delayTime;
	 }
	 public void run() {
	  try {
	    for(;;) {
	       System.out.print(word +" ");
	       Thread.sleep(delay);
	    }
	  } catch (InterruptedException e) {
	      return;
	    }
	 }
	 public static void main(String[] args) {
	    Runnable ping = new RunPingPong("ping", 33);
	    Runnable pong = new RunPingPong("PONG", 100);
	    new Thread(ping).start();
	    new Thread(pong).start();
	 }
	}

