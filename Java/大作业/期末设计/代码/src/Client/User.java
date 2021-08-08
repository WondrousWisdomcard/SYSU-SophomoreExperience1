package Client;

public class User {
	public String registWord;
	public String password;
	public User(String r,String p) {
		this.registWord = r;
		this.password = p;
	}
	public String toString() {
		return registWord + " " + password;
	}
}
