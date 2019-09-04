package restapi.twitter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restapi.utils.RIUtils;

import static io.restassured.RestAssured.given;

public class Twitter {

	String consumerKey = "0Tff9F64llKJ5f4GBRjLykHZO";
	String consumerSecret = "Y41HrEy5ckCtdAKvvg0YNZ05HuO0w3uCxwzNdYwSgDdCQQL9Yn";
	String AccessToken = "1144499519213592576-hai3XEPWOmZc908wLGGe0zAQuKJcZ6";
	String TokenKey = "kZ1oINZwV320BrAg7fRrUkhEFd3OSvBiIDbafYedIzlyi";

	public static void main(String[] args) {

		Twitter t = new Twitter();
//		t.getTweets();
//		t.getTweets1();
		t.postTweet("Welcome back");
//		t.deleteTweet();
	}

	
	
	
	public void getTweets(){

		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";

		//		RIUtils.setProxy();
		Response response = given().
				auth().oauth(consumerKey, consumerSecret, AccessToken, TokenKey).
				queryParam("count", "1").
				when().get("/home_timeline.json").then().extract().response();

		//		System.out.println("Response: "+response.asString());

		JsonPath json = new JsonPath(response.asString());
		System.out.println("latest tweet: "+ json.getString("text"));
		System.out.println("Id: "+ json.getString("id"));		
	}	

	public void getTweets1(){

		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";


		RequestSpecification request = given().		
				auth().oauth(consumerKey, consumerSecret, AccessToken, TokenKey).
				queryParam("count", "1").
				when();
		request.relaxedHTTPSValidation();

		RIUtils.setProxy();

		Response response = request.get("/home_timeline.json").then().extract().response();		
//		System.out.println("Response: "+response.asString());		
		JsonPath json = new JsonPath(response.asString());
		System.out.println("latest tweet: "+ json.getString("text"));
		System.out.println("Id: "+ json.getString("id"));		
	}	


	public void postTweet(String tweet){

		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";

		RequestSpecification request = given().
				auth().oauth(consumerKey, consumerSecret, AccessToken, TokenKey).
				queryParam("status", tweet).
				when();
		request.relaxedHTTPSValidation();

		RIUtils.setProxy();

		Response response = request.post("/update.json").then().extract().response();
		
		JsonPath json = new JsonPath(response.toString());
		System.out.println("Id: "+json.getString("id"));
		System.out.println("Posted tweet: "+json.getString("text"));				
	}


	public void deleteTweet(){

		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/destroy";

		RequestSpecification request = given().
				auth().oauth(consumerKey, consumerSecret, AccessToken, TokenKey).
				when();
		request.relaxedHTTPSValidation();

		RIUtils.setProxy();

		Response response = request.post("/1144558888416493568.json").then().extract().response();
		JsonPath json = new JsonPath(response.toString());
		System.out.println("id: "+ json.getString("id"));
		System.out.println("Deleted Tweet is: "+ json.getString("text"));
	}
}
