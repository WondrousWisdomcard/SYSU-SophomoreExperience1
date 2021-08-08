package test;

class Producer extends Thread {
	  Queue queue;

	  Producer(Queue queue) {
	    this.queue = queue;
	  }

	  public void run() {
	    int i = 0;
	    while(true) {
	      queue.add(i++);
	    }
	  }
	}
