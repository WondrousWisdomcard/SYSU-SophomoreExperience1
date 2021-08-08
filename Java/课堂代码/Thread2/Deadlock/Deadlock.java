package test6;

public class Deadlock {

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bower.bowBack(this);
		}

		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend lily = new Friend("Lily");
		final Friend lucy = new Friend("Lucy");
		new Thread(new Runnable() {
			public void run() {
				lily.bow(lucy);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				lucy.bow(lily);
			}
		}).start();
	}
}
