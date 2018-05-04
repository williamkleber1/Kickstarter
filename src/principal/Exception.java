package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class Exception {

	public static Scanner input = new Scanner(System.in);


	public static  int input_int() {
		int a = 0;
		try{
			 a = input.nextInt();

		}
		catch(InputMismatchException e){
			a = -1;
			System.out.println(a);
		}
			return a;
	}

}
