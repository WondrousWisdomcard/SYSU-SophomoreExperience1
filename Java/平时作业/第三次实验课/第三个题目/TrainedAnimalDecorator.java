
public class TrainedAnimalDecorator extends AnimalDecorator{
	public TrainedAnimalDecorator(Animal animal) {
		super(animal);
	}
	private void shakeHands() {
		System.out.println("\tThe trained " + super.getType() + " \"" + super.getName() + "\" is shaking hands with you." );
	}
	private void sitDown() {
		System.out.println("\tThe trained " + super.getType() + " \"" + super.getName() + "\" sit down on the floor." );
	}
	public void showSkills() {
		System.out.println("The scientific " + super.getType() + " \"" + super.getName() + "\" is showing its skills:");
		shakeHands();
		sitDown();
	}
}
