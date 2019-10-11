package restapi.google;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class PlaceSearch {

	public static void main(String[] args) {

		placeSearch1();
	}

	public static void placeSearch1(){

		System.out.println("---Started---");
		RestAssured.baseURI = "https://maps.googleapis.com";
		RequestSpecification request = (RequestSpecification) given().
				param("location", "-33.8670522,151.1957").
				param("key", "AIzaSyDmDNtBaO74Pr-F14ZsTDytuT4WrEd3ULg").
				param("radius", "500").log().all().
				when();
		Response response = request.get("/maps/api/place/nearbysearch/json");

		System.out.println("Status Code"+ response.getStatusCode());
		System.out.println("Status Line"+ response.getStatusLine());
//		System.out.println("Response String: "+ response.asString());
//		System.out.println("Response body: "+ response.body().asString());
		System.out.println("Place Name: "+GRestUtils.getPlaceName(response));
		System.out.println("Place Latitude: "+GRestUtils.getLocationLat(response));
		System.out.println("Place Langitude: "+GRestUtils.getLocationLng(response));
		
		System.out.println("-----Done------");

	}

	public static void placeSearch(){

		System.out.println("---Started---");
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		param("location", "-33.8670522,151.1957").
		param("key", "AIzaSyDmDNtBaO74Pr-F14ZsTDytuT4WrEd3ULg").
		param("radius", "500").log().all().
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().
		body("results[0].name", equalToIgnoringCase("Sydney"));

		System.out.println("-----Done------");
	}



}
