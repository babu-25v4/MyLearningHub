package restapi.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;

public class RIUtils {

	public static void setProxy() {
//		String proxyURL = getProperty("proxyURL");
//		String port = getProperty("proxyPortNumber");
		String proxyURL = "www-proxy.us.oracle.com";
		String port = "80";
		
		int proxyPort = Integer.parseInt(port);

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
		} else {
			System.out.println("Network in Proxy");
			RestAssured.proxy = ProxySpecification.host(proxyURL).withPort(proxyPort).withScheme("http");
		}
	}
	
}
