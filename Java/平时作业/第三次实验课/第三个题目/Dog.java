
public class Dog implements Animal{
	private String name;
	private String type;
	public Dog(String name) {
		this.name = name;
		type = "Dog";
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void eat() {
		System.out.println("The " + type + " \"" + name + "\" is eating the food" );
	}
	public void bark() {
		System.out.println("Woof Woof Woof");
	}
	public void showSkills() {
		System.out.println("The " + type + " \"" + name + "\" don't have any skill." );
	}
	
}
