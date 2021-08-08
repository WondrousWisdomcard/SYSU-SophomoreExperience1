package Third;

public class BeFollowed implements Observer
{	
	public void notify(User pageUser, User follower)
	{
		pageUser.notify("You are followed by " + follower.getName());
	}
}