package restapi.ri;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;


public class RestTest {

	public static void main(String[] args) {
		
		String arr [] = {"", "", "", ""};
		
		
		RestLogin.restLogin("babuipush", "Welcome1234%", "password");
		
		
//		generateSMSShortURLClickEvents("","","http://ri2b.rsysi.com/HGhUtc6k");		
//		generateSMSShortURLClickEvents("","","https://qa82.ri2.mycampaign.com/pub/acc?_ri_=X0Gzc2X%3DYQpglLjHJlTQGzb1FN4cizgbqPUtb9JkFUmmIzfzc8IdgRjeWuoYdnAthzbJLi8ljgpzdcF2CVXtpKX%3DSCRSWBCT&_ei_=EkZxRNOJ-vWdFjt_xLs93M0qSyepZLyDXhW3y8eCVzNxZSMduuta8SbpFt_cxxIhgRramauQn_GK5387y9Q-twVqXX4FQZlm4VIvM2Hzk4v2i-a7YPmvi3v7DMjD9OuZmyfiHfqwFg.Jg%3D%3D");						
	}
	
		
	public static void generateSMSShortURLClickEvents(String testCaseDescription, String expectedStatuscode, String smsShortURL){

		RequestSpecification request = RestAssured.given();
//		request.header("Content-Type", "application/x-www-form-urlencoded");
//		request.relaxedHTTPSValidation();
		System.out.println(testCaseDescription);
//		Enable proxy if not connected to Bastion - OCNA
//		setRIProxy();
		Response response = request.get(smsShortURL);

		responseValidator(response, Integer.parseInt(expectedStatuscode));
	}
	
	
	private static void responseValidator(Response response, int expectedResponseCode){
		System.out.println("Response Status Line: "+response.getStatusLine());
		System.out.println("Response Status Code: "+response.getStatusCode());
		System.out.println("Response ContentType: "+response.contentType().toString());
//		Assert.assertEquals(response.getStatusCode(), expectedResponseCode, " Test Failed: Invalid Response Code");		
	}
	
	public static void setRIProxy() {
		RestAssured.proxy = ProxySpecification.host("www-proxy.us.oracle.com").withPort(80).withScheme("https");
	}
		
	
	
}
