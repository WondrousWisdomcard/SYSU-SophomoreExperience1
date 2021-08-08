
public class AnimalDecorator implements Animal{
	private Animal animal;
	public AnimalDecorator(Animal animal) {
		this.animal = animal; 
	}
	public String getType() {
		return animal.getType(); 
	}
	public void setType(String type) {
		animal.setType(type);
	}
	public void eat() {
		animal.eat();
	}
	public void bark() {
		animal.bark();
	}
	public void showSkills() {
		animal.showSkills();
	}
	public String getName() {
		return animal.getName();
	}
}
