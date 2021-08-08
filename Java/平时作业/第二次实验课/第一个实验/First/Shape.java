package First;

public abstract class Shape {
	 // fields
	 protected String name;
	 
	 // methods
	 public Shape(String name){
	 this.name = name;
	 }
	 public String getName() {
	 return name;
	 }
	 public void setName(String name) {
	 this.name = name;
	 }
	 
	 // abstract method
	 public abstract double getArea();
	 public abstract void showDescription();
}
