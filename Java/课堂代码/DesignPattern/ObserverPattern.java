import java.util.*;

public class ObserverPattern {
	public static void main(String[] args) {
		Subject1 subject = new ConcreteSubject();
		Observer obs1 = new ConcreteObserver1();
		Observer obs2 = new ConcreteObserver2();
		subject.add(obs1);
		subject.add(obs2);
		subject.notifyObserver();
	}
}

// abstract subject
abstract class Subject1 {
	protected List<Observer> observers = new ArrayList<Observer>();

	// add
	public void add(Observer observer) {
		observers.add(observer);
	}

	// remove
	public void remove(Observer observer) {
		observers.remove(observer);
	}

	public abstract void notifyObserver(); // notify
}

// concrete subject
class ConcreteSubject extends Subject1 {
	public void notifyObserver() {
		System.out.println("Concrete subject change");
		System.out.println("--------------");

		for (Object obs : observers) {
			((Observer) obs).response();
		}

	}
}

// abstract observer
interface Observer {
	void response(); // ��Ӧ
}

// ConcreteObserver1
class ConcreteObserver1 implements Observer {
	public void response() {
		System.out.println("ConcreteObserver1 responds");
	}
}

// ConcreteObserver2
class ConcreteObserver2 implements Observer {
	public void response() {
		System.out.println("ConcreteObserver2 responds");
	}
}