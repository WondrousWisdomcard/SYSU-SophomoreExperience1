package Third;
import java.util.ArrayList;
import java.util.List;
public class User {
	private String name;
	private List<User> followList = new ArrayList<User>();
	private List<User> fansList = new ArrayList<User>();
	private List<String> messageList = new ArrayList<String>();
	
	public User(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	public List<User> getFollowList()
	{
		return followList;
	}
	public List<User> getFansList()
	{
		return fansList;
	}
	
	public void notify(String message)
	{
		messageList.add(message);
	}
	
	public void showFollowList()
	{
		System.out.println(name + "'s follow list:");
		for(User obs:followList)
		{
			System.out.println(obs.getName());
		}
	}
	public void showFansList()
	{
		System.out.println(name + "'s fans list:");
		for(User obs:fansList)
		{
			System.out.println(obs.getName());
		}
	}
	public void showMessageList()
	{
		System.out.println(name + "'s message list:");
		for(String obs:messageList)
		{
			System.out.println(obs);
		}
	}
}
