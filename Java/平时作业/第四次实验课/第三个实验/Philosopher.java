
public class Philosopher implements Runnable{
	private int philosopherNum; // index
	private Fork left;
	private Fork right;
	
	public Philosopher(int num, Fork l, Fork r) {
		philosopherNum = num;
		left = l;
		right = r;
	}
	
	public void think() {
		System.out.println("Philosopher " + philosopherNum + " thinks.");
	}
	
	public void eat() {
		//�涨��������ѧ������������ߵĿ��ӣ�Ȼ����ȥ�����ұߵĿ��ӣ�
		//��ż���ŵ���ѧ�����෴
		//�����Ļ����ܱ�֤һ����ѧ���ܻ������������ɽ��ͣ��Ӷ��ͷ�����ռ�õ���Դ

		if(philosopherNum % 2 == 1) {
			synchronized(left) {
				System.out.println("Philosopher " + philosopherNum + " takes left fork");
				synchronized(right) {
					System.out.println("Philosopher " + philosopherNum + " takes right fork.");
					System.out.println("Philosopher " + philosopherNum + " eats spaghetti.");
				}
			}
		}
		else {
			synchronized(right) {
				System.out.println("Philosopher " + philosopherNum + " takes right fork.");
				synchronized(left) {
					System.out.println("Philosopher " + philosopherNum + " takes left fork");
					System.out.println("Philosopher " + philosopherNum + " eats spaghetti.");
				}
			}
		}
	}
	
	public void run() {
		int i = 1000;
		while(i > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			think();
			eat();
		}
	}

}
