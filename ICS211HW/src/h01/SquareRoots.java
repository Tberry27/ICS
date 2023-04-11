
package h01;

public class SquareRoots {
	public static double []root(int num){
			//if statement to catch inputs less than 2 and return a -1
		if(num<2) {
			double [] a = {-1.0};
			return a;
		}
			//creating double array to return with sqrt values
		double[] results = new double [num - 1];
			//for loop to  sqrt array and assign to results array
		for(int i=2; i<= num;i++) {
			double root = Math.sqrt(i);
			results[i-2]=root;
		}	
		
		return results;
	}
}
