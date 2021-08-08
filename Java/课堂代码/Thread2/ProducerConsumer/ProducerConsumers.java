package test;

class ProducerConsumers {
	  public static void main(String args[]) {
	    Queue queue = new Queue();
	    new Producer(queue).start();
	    new Consumer("ConsumerA", queue).start();
	    new Consumer("ConsumerB", queue).start();
	    new Consumer("ConsumerC", queue).start();
	  }
	}

