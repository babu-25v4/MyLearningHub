package javapractice;

public class CustomException {

	public static void main(String[] args) {
	
		try {
			throw new MyCustomException("This is my custom Exception");
		} catch (MyCustomException e) {
			e.printStackTrace();
			System.out.println("--> "+e);
		}

	}

}
