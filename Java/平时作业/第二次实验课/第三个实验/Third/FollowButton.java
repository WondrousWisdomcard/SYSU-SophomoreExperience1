package Third;
import java.util.ArrayList;
import java.util.List;
public class FollowButton {
	private User pageUser;
	private List<Observer> observerList = new ArrayList<Observer>();
	
	public FollowButton(User pageUser)
	{
		this.pageUser = pageUser;
	}
	
	public void click(User clicker)
	{
		for(Observer obs:observerList)
		{	
			obs.notify(pageUser,clicker);
		}
	}
	
	public void addObserver(Observer observer)
	{
		observerList.add(observer);
	}
	
}
