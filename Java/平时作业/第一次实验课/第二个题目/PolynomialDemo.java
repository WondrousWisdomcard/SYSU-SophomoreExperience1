public class PolynomialDemo {
 public static void main(String[] args)
 {
 Polynomial f = new Polynomial(10,9,8);
 Polynomial f1 = new Polynomial(1, 0, 0);
 Polynomial f2 = new Polynomial(1, 0, 2);
 double[] tempArray = {0.0, 1.0, 3.0};
 // Set Method Test
 System.out.println("Set Method Test");
 f.showPolynomial();
 f.setA(-10);
 f.showPolynomial();
 f.setB(-1908);
 f.showPolynomial();
 f.setC(190908.87);
 f.showPolynomial();
 // F(x) Calculation Test
 System.out.println("\nCalculation Test");
 f1.showPolynomial();
 f2.showPolynomial();
 System.out.println("");
 for(int i = 0; i < tempArray.length;i++) {
 System.out.println("f1(" + String.valueOf(tempArray[i]) +
")=" + String.valueOf(f1.getY(tempArray[i])));
 System.out.println("f2(" + String.valueOf(tempArray[i]) +
")=" + String.valueOf(f2.getY(tempArray[i])));
 }
 // F(x)=0 Solution Test
 System.out.println("\nSolution Test");
 for(int i = 0; i < tempArray.length;i++){
 System.out.println("y = " + String.valueOf(tempArray[i]));
 boolean result1 = f1.hasSolution(tempArray[i]);
 boolean result2 = f2.hasSolution(tempArray[i]);
 System.out.print("f1:");
 System.out.println(result1);
 if(result1){
 f1.showSolution(tempArray[i]);
 }
 System.out.print("f2:");
 System.out.println(result2);
 if(result2){
 f2.showSolution(tempArray[i]);
 }
 System.out.println(""); 
 }
 }
}