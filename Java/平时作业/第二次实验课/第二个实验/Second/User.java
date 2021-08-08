package Second;
import java.util.ArrayList;
import java.util.List;

public class User implements Sender, Receiver{
	protected String name;
	protected List<String> messageList = new ArrayList<String>();
	
	public User(String str)
	{
		name = str;
	}
	
	public void send(Receiver receiver, String message)
	{
		String mes = "[From " + name + "]"+ message;
		receiver.receive(this,mes);
	}
	
	public void receive(Sender sender, String message)
	{
		messageList.add(message);
	}
	
	public void showMessages()
	{
		for(String obs:messageList)
		{
			System.out.println(obs);
		}
	}
}
