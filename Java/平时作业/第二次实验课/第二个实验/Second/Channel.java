package Second;
import java.util.ArrayList;
import java.util.List;

public class Channel implements Receiver{
	protected String name;
	protected List<User> userList = new ArrayList<User>();
	
	public Channel(String str)
	{
		name = str; 
	}
	public void receive(Sender sender, String message)
	{
		String mes = "[From " + name + "]" + message;
		for(User obs:userList)
		{
			if(sender != obs)
			{
				obs.receive(sender,mes);
			}
		}
	}
	public void add(User user)
	{
		userList.add(user);
	}
	public void remove(User user)
	{
		userList.remove(user);
	}
}
