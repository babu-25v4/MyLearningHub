package javapractice;

public class StringReverse {

	public static void main(String[] args) {

		System.out.println(reverse("Welcome"));
		System.out.println(reverseStringWithLoop("Welcome"));
		System.out.println(reverseStringWithBuiltInMethod("Welcome"));
	}

	/*Using recursion:*/
	static String reverse(String str) {
		if(str.length() == 0)
			return "";
		return str.charAt(str.length() - 1) + reverse(str.substring(0,str.length()-1));
	}

	/*Using loop*/
	static String reverseStringWithLoop(String str) {
		int length = str.length();
		char[] arrayChar = str.toCharArray();
		for(int i=0; i< length/2; i++) {
			char ch = str.charAt(i);
			arrayChar[i] = arrayChar[length-1-i];
			arrayChar[length-1-i] = ch;
		} 
		return new String(arrayChar);
	} 

	/*Using stringbuilder*/
	static String reverseStringWithBuiltInMethod(String str){
		if(str.isEmpty() || str == null) return str; 
		return new StringBuilder(str).reverse().toString(); 
	} 

}
