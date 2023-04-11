package h01;

import java.io.FileNotFoundException;

public class Hw1{
	public static void main(String[] args) throws FileNotFoundException {
			// creating random int variable
		int randomInt = (int)(Math.random()*11);
		
			//creating a double array that calls Sqrts method and stores values
		double[] array = SquareRoots.root(randomInt);
			
			//Print statement for random int
		System.out.print(randomInt+", ");
			// for loop printing array
		for (int i =0; i<array.length ;i++) {
			System.out.print(array[i]);
				if(i<array.length-1) {
					System.out.print(",");
				}
		}
			//for loop sending arg to FileHelpers class and printing character count
		System.out.println();
		for(String arg : args) {
			System.out.println((arg)+ " " + FileHelpers.Filehelper(arg));
		}
	}
}
