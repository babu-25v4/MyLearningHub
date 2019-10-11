package restapi.ri;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class PushCampaign {

	public static Response response;
	public static String endPoint;
	public static String authToken;
	
	public static String payLoad = "{" +
		    "\"recipientData\": [" +
            	" {" +
            	  "\"customerId\": \"\"," +
                 "\"emailAddress\": \"surender.sankineni@oracle.com\"," +
                 "\"recipientId\": \"\"," +
                 "\"mobileNumber\": null," +
                 "\"emailSHA256Hash\": null," +
                 "\"emailMD5Hash\": null," +
                 "\"deviceId\": \"81006d6b-23fd-4d65-a0b6-f20163506e02\"," +
                 "\"apiKey\": \"ABErcWPfJPhgWHFaVoDEk3hrU\"," +
                 "\"listType\": \"PUSH\"," +
                 "\"optionalData\": [" +
                     "{" +
                         "\"name\": \"CUSTOM1\"," +
                         "\"value\": \"c1a_value_new\"" +
                     "}," +
                     "{" +
                         "\"name\": \"CUSTOM2\"," +
                         "\"value\": \"c2a_value_new\"" +
                     "}" +
                 "]" +
             "}" +
         "]" +
     "}";

	
	public static void main(String[] args) {		
		
		
		launchPushCampaing1("B1_01_LaunchApp_All_Options");
	}

	
	public static void launchPushCampaing1(String campaignName){
		
		response = RestLogin.restLogin("babuipush", "Welcome1234%", "password");
		if(response != null){
			endPoint = RestUtils.getEndPoint(response);
			authToken = RestUtils.getAuthToken(response);
		}
		System.out.println("authToken: "+authToken);
		System.out.println("Final endPoint: "+endPoint);
		
		RestAssured.baseURI = endPoint;		
		RequestSpecification request = given().
			header("Content-Type", "application/json").
			header("Authorization", authToken).
			body(payLoad).
//			log().all().
		when();
			Response response = request.post("/rest/api/v1/campaigns/"+campaignName+"/push");
			
			System.out.println("Status Code: "+response.getStatusCode());	
			System.out.println("Status line: "+response.getStatusLine());
			System.out.println("Response body: "+response.body().asString());
					
		
		
	}
	
	public static void launchPushCampaing(String campaignName){
		
		response = RestLogin.restLogin("babuipush", "Welcome1234%", "password");
		if(response != null){
//			endPoint = RestUtils.getEndPoint(response)+"/rest/api/v1/campaigns/"+campaignName+"/push";
			endPoint = RestUtils.getEndPoint(response);
			authToken = RestUtils.getAuthToken(response);
		}
		System.out.println("authToken: "+authToken);
		System.out.println("Final endPoint: "+endPoint);
		
		RestAssured.baseURI = endPoint;		
		given().
			header("Content-Type", "application/json").
			header("Authorization", authToken).
			body(payLoad).log().all().
		when().
			post("/rest/api/v1/campaigns/"+campaignName+"/push").
		then().
			assertThat().statusCode(200);
			
//		System.out.println("Status Code: "+response.getStatusCode());
//		System.out.println("Status line: "+response.getStatusLine());				
		
	}
	
}
