package restapi.google;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class PlaceSearch {
	
	public static void main(String[] args) {
		
		placeSearch();
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
		then().assertThat().statusCode(200);
		
			
	}
	
}
