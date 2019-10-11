package restapi.google;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GRestUtils {

	public static String getPlaceName(Response response){
		JsonPath path = response.jsonPath();
		return path.get("results[0].name").toString();
	}
	
	public static String getLocationLat(Response response){
		JsonPath path = response.jsonPath();
		return path.get("results[0].geometry.location.lat").toString();
	}
	
	public static String getLocationLng(Response response){
		JsonPath path = response.jsonPath();
		return path.get("results[0].geometry.location.lng").toString();
	}
	
}
