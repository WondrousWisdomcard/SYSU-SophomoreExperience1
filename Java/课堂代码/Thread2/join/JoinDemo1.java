package test2;

class JoinDemo1 {
	public static void main(String args[]) {
		ThreadM tm = new ThreadM();
		tm.start();
		ThreadN tn = new ThreadN();
		tn.start();
		try {
			tm.join();
			tn.join();
			System.out.println("Both threads have finished");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
