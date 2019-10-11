package restapi.ri;

import java.net.InetAddress;
import java.net.UnknownHostException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;

public class RestUtils {




	public static String getAuthToken(Response response){

		JsonPath path = response.jsonPath();
		return path.get("authToken").toString();
	}

	public static String getEndPoint(Response response){

		JsonPath path = response.jsonPath();
		return path.get("endPoint").toString();
	}

	public static void setProxy() {
		String proxyURL = "www-proxy.us.oracle.com";
		String port = "80";
		int proxyPort = 0;
		if (port != null) {
			proxyPort = Integer.parseInt(port);
		}

		InetAddress host = null;
		String ip = null;
		String ocnaOracleIP = "10.74";
		String ocnaOthers = "10.197";
		/*
		 * String ocnaChicago2 = "10.197"; String ocnaAmsterdam = "10.197"; String
		 * ocnaSydney = "10.197"; String ocnaMelbournce=""; String ocnaLondon="";
		 */
		try {
			host = InetAddress.getLocalHost();
			ip = host.getHostAddress().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (ip.contains(ocnaOracleIP) || ip.contains(ocnaOthers)) {
			System.out.println("Network in myaccess.oracle-ocna.com and no Proxy");
			System.out.println("Network in myaccess.oracle-ocna.com and no Proxy");
		} else if (proxyURL != null) {
			System.out.println("Network in Proxy");
			System.out.println("Network in Proxy");
			RestAssured.proxy = ProxySpecification.host(proxyURL).withPort(proxyPort).withScheme("http");
			System.getProperties().put("https.proxyHost", proxyURL);
			System.getProperties().put("https.proxyPort", proxyPort);

			// Set proxy for bs
			System.getProperties().put("proxyHost", proxyURL);
			System.getProperties().put("proxyPort", proxyPort);
		}
	}


}
