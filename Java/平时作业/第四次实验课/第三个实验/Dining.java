public class Dining {
	
	public static void main(String[] args) {
		Fork fork1 = new Fork(1);
		Fork fork2 = new Fork(2);
		Fork fork3 = new Fork(3);
		Fork fork4 = new Fork(4);
		Fork fork5 = new Fork(5);
		
		Philosopher ph1 = new Philosopher(1,fork5,fork1);
		Philosopher ph2 = new Philosopher(2,fork1,fork2);
		Philosopher ph3 = new Philosopher(3,fork2,fork3);
		Philosopher ph4 = new Philosopher(4,fork3,fork4);
		Philosopher ph5 = new Philosopher(5,fork4,fork5);
		
		Thread t1 = new Thread(ph1);
		Thread t2 = new Thread(ph2);
		Thread t3 = new Thread(ph3);
		Thread t4 = new Thread(ph4);
		Thread t5 = new Thread(ph5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}
	
}
