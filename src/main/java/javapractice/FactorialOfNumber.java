package javapractice;

public class FactorialOfNumber {

	public static void main(String[] args) {
		
		factorialOfNumber(6);
		System.out.println("Factorial of number - 5 is: "+factorialOfNumberRecursive(5));

	}
	
	public static void factorialOfNumber(int n){		
		int fact = 1;
		for(int i=1; i<=n; i++){
			fact *= i; 
		}
		System.out.printf("Factorial of %d = %d", n, fact);	
		System.out.println();
	}
	
	public static int factorialOfNumberRecursive(int num){
		if(num == 0)
			return 1;
		else
			return (num * factorialOfNumberRecursive(num-1));
	}
	

}
