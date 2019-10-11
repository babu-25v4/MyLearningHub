package javapractice;

public class Java13Features {

	public static void main(String[] args) {
		
		System.out.println("Test main");
		String str = ""
				+ "line1"
				+ "line2"
				+ "line3"
				+"";

//		Java 13 introduced - Text Blocks (Preview)
		/*String str2 = """
				line 1
				line 2
				line 3""";

		String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;          
		 */

//		Java 13 introduced -Switch Expressions (Preview)
		/*switch (day) {
	    case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
	    case TUESDAY                -> System.out.println(7);
	    case THURSDAY, SATURDAY     -> System.out.println(8);
	    case WEDNESDAY              -> System.out.println(9);
		 */

	}

}
