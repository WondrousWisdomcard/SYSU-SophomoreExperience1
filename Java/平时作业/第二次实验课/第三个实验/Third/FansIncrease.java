package Third;

public class FansIncrease implements Observer
{	
	public void notify(User pageUser, User follower)
	{
		pageUser.getFansList().add(follower);
	}
}