public class PrimeCalculator implements Runnable  {
	private int lowerBound;
	private int upperBound;
	private int amount;
	private boolean hasBeenCalculated;
	
	public PrimeCalculator(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.amount = -1;
		this.hasBeenCalculated = false;
	}
	
	public void run(){
		if(hasBeenCalculated == false) {
			hasBeenCalculated = true;
			amount = 0;
			int i,j;
			for(i = lowerBound; i < upperBound; i++) {
				for(j = 2; j < i; j++) {
					if(i % j == 0)
						break;
				}
				if(i == j)
					amount++;
			}
		}	
	}
	
	public int getAmount() {
		return amount;
	}
}
