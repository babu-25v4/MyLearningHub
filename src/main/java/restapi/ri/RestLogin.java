package restapi.ri;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestLogin {

	static Response response = null;

	public  static Response restLogin(String username, String password, String auth_type){

		System.out.println("----------Begin Login----------");

		RestUtils.setProxy();
		try {
			String baseURI = "https://login.qa1.responsys.net/rest/api/v1/auth/token";
			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/x-www-form-urlencoded");
			request.formParam("user_name", username);
			request.formParam("password", password);
			request.formParam("auth_type", auth_type);
			response = request.post(baseURI);
			
		} catch (Exception e) {
			response = null;
		}
		System.out.println("Response body: "+response.getBody().asString());
		System.out.println("authToken: "+RestUtils.getAuthToken(response));	
		System.out.println("endPoint: "+RestUtils.getEndPoint(response));	

		return response;
	}

	/*public  static void restLogin1(String username, String password, String auth_type){

		System.out.println("----------begin----------");
		RestUtils.setProxy();

		String baseURI = "https://login.qa1.responsys.net/rest/api/v1/auth/token";
		@SuppressWarnings("deprecation")
		RequestSpecification request =  RestAssured.given().parameters("user_name", username, "password", password, "auth_type", auth_type);
		Response response  = request.contentType("application/x-www-form-urlencoded").
				post(baseURI);	

		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Status Code: "+response.getBody().asString());
	}*/

}
