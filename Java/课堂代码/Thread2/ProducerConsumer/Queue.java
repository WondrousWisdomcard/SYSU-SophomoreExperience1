package test;

class Queue {
	private final static int SIZE = 10;
	int array[] = new int[SIZE];
	int r = 0;
	int w = 0;
	int count = 0;

	synchronized void add(int i) {
		while (count == SIZE) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
				System.exit(0);
			}
		}
		array[w++] = i;
		if (w >= SIZE)
			w = 0;
		++count;
		notifyAll();
	}

	synchronized int remove() {
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
				System.exit(0);
			}
		}
		int element = array[r++];
		if (r >= SIZE)
			r = 0;
		--count;
		notifyAll();
		return element;
	}
}
