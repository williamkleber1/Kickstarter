package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract  class Exception {

	public static Scanner input = new Scanner(System.in);


	public static  int inputInt() {
		int a = 0;
		try{
			 a = input.nextInt();

		}
		catch(InputMismatchException e){
			a = -1;
			input.reset();
			input.next();
		}
		return a;
	}
	
	public static double inputDouble() {
		double a = 0;
		try{
			 a = input.nextDouble();

		}
		catch(InputMismatchException e){
			a = -1;
			input.reset();
			input.next();
		}
		return a;
		
	}

}
