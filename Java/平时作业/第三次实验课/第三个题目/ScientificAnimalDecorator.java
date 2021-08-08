
public class ScientificAnimalDecorator extends AnimalDecorator{
	public ScientificAnimalDecorator(Animal animal) {
		super(animal);
	}
	private void doExperiment() {
		System.out.println("\tThe scientific " + super.getType() + " \"" + super.getName() + "\" is doing experiment." );
	}
	private void writePaper() {
		System.out.println("\tThe scientific " + super.getType() + " \"" + super.getName() + "\" is writing the paper." );
	}
	public void showSkills() {
		System.out.println("The scientific " + super.getType() + " \"" + super.getName() + "\" is showing its skills:" );
		doExperiment();
		writePaper();
	}
}
