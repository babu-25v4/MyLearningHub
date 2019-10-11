package javapractice;
interface Maths
{
	int add(int i, int j);
	default int sub(int i, int j){
		return i - j ;
	}
	default int mul(int i, int j){
		return i * j ;
	}
}

abstract class Maths1{
	double div(double i, double j){
		return i/j;
	}
}

public class InterfaceMath extends Maths1 implements Maths {

	public static void main (String[] args) {
		InterfaceMath t = new InterfaceMath();
		System.out.println("Add of 20 + 10 is: "+t.add(20, 10));
		System.out.println("Sub of 30 - 20 is: "+t.sub(30, 20));
		System.out.println("Mul of 5 * 6 is: "+t.mul(5, 6));
		System.out.println("div of 50 / 6 is: "+t.div(50, 6));
	}

	public int add(int i, int j){
		return i + j;
	}

	public int mul(int i, int j){
		return i * j+1 ;
	}
}