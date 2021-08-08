public class AnimalDecoratorTest {
	public static void main(String args[]) {
		Cat cat = new Cat("Tom");
		Dog dog = new Dog("Herry");
		TrainedAnimalDecorator trainedCat = new TrainedAnimalDecorator(new TrainedAnimalDecorator(cat));
		TrainedAnimalDecorator trainedDog = new TrainedAnimalDecorator(new TrainedAnimalDecorator(dog));
		ScientificAnimalDecorator scientificCat = new ScientificAnimalDecorator(new ScientificAnimalDecorator(cat));
		ScientificAnimalDecorator scientificDog = new ScientificAnimalDecorator(new ScientificAnimalDecorator(dog));

		cat.eat();
		cat.bark();
		cat.showSkills();
		
		System.out.println("");
		
		dog.eat();
		dog.bark();
		dog.showSkills();
		System.out.println("");
		
		trainedCat.eat();
		trainedCat.bark();
		trainedCat.showSkills();
		
		System.out.println("");
		
		trainedDog.eat();
		trainedDog.bark();
		trainedDog.showSkills();
		
		System.out.println("");
		scientificCat.eat();
		scientificCat.bark();
		scientificCat.showSkills();
		
		System.out.println("");
		
		scientificDog.eat();
		scientificDog.bark();
		scientificDog.showSkills();
		
		System.out.println("");
	}
}