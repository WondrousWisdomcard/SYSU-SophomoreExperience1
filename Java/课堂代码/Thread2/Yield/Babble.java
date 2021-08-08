package test;

class Babble extends Thread {
	static boolean doYield;
	static int howOften;
	private String word;

	Babble(String whatToSay) {
		word = whatToSay;
	}

	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield(); // let other threads run
		}
	}

	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		// create a thread for each world
		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}
