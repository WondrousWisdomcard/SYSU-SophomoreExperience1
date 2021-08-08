package test3;

public class InterruptionInJava implements Runnable {
	private volatile static boolean on = false;

	public static void main(String[] args) throws InterruptedException {
		Thread testThread = new Thread(new InterruptionInJava(), "InterruptionInJava");
		// start thread
		testThread.start();
		Thread.sleep(1000);
		InterruptionInJava.on = true;
		testThread.interrupt();

		System.out.println("main end");

	}

	@Override
	public void run() {
		while (!on) {
			try {
				System.out.println("thread sleeping starts");
				Thread.sleep(10000000);
				System.out.println("thread sleeping ends");
			} catch (InterruptedException e) {
				System.out.println("caught exception right now: " + e);
			}
		}
	}
}
