package Third;

public class FollowIncrease implements Observer
{	
	public void notify(User pageUser, User follower)
	{
		follower.getFollowList().add(pageUser);
	}
}
