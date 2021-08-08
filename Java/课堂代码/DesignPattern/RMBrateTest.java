import java.util.*;

public class RMBrateTest {
	public static void main(String[] args) {
		Rate rate = new RMBrate();
		Company watcher1 = new ImportCompany();
		Company watcher2 = new ExportCompany();
		rate.add(watcher1);
		rate.add(watcher2);
		rate.change(10);
		rate.change(-9);
	}
}

// abstract: Rate
abstract class Rate {
	protected List<Company> companys = new ArrayList<Company>();

	// add
	public void add(Company company) {
		companys.add(company);
	}

	// remove
	public void remove(Company company) {
		companys.remove(company);
	}

	public abstract void change(int number);
}

// consrete��RMBrate
class RMBrate extends Rate {
	public void change(int number) {
		for (Company obs : companys) {
			((Company) obs).response(number);
		}
	}

}

// abstrct observer: Company
interface Company {
	void response(int number);
}

// concreteObserver1��ImportCompany
class ImportCompany implements Company {
	public void response(int number) {
		if (number > 0) {
			System.out.println("RMBrate increase" + number + ", improved the profit margin of import companies");
		} else if (number < 0) {
			System.out.println("RMBrate decrease" + (-number) + ", reduced the profit margin of import companies");
		}
	}
}

// concreteObserver2��ExportCompany
class ExportCompany implements Company {
	public void response(int number) {
		if (number > 0) {
			System.out.println("RMBrate increase" + number + ", reduced the profit margin of export companies");
		} else if (number < 0) {
			System.out.println("RMBrate increase" + (-number) + ", improved the profit margin of export companies");
		}
	}
}