import java.util.ArrayList;
import java.util.List;

public class TicketWindow implements Runnable{
	private int windowNumber;
	private List<Integer> ticketList = new ArrayList<Integer>();
	
	public TicketWindow(int windowNumber, List<Integer> ticketList) {
		this.windowNumber = windowNumber;
		this.ticketList = ticketList;
	}
	
	public synchronized void sell() {
		if(!ticketList.isEmpty())
		{
			System.out.println(Thread.currentThread().getName() + ": Ticket " + ticketList.get(0) + " is sold.");
			ticketList.remove(0);
		}
	}
	
	public void run() {
		while(!ticketList.isEmpty()) {
			sell();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
