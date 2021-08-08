import java.util.ArrayList;
import java.util.List;

public class TicketWindowTest {
	public static void main(String[] args){
		List<Integer> ticketList = new ArrayList<Integer>();
		
		for(int i = 0; i < 20; i++) {
			ticketList.add(i);
		}
		
		TicketWindow test1 = new TicketWindow(3, ticketList);
		
		Thread t1 = new Thread(test1);
		t1.setName("Window 1");
		
		Thread t2 = new Thread(test1);
		t2.setName("Window 2");
	
		Thread t3 = new Thread(test1);
		t3.setName("Window 3");
		
		t1.start(); 
		t2.start(); 
		t3.start(); 
		
	}
}
