package test;

class Consumer extends Thread {
	  String str;
	  Queue queue;

	  Consumer(String str, Queue queue) {
	    this.str = str;
	    this.queue = queue;
	  }

	  public void run() {
	    while(true) {
	    	System.out.println(str + ": " + queue.remove());
	    }
	  }
	}

