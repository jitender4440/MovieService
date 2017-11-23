package com.luxoft.util;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

/**
 * Utility Class
 *
 * @author Jitender Kumar
 */

public class AppUtility {
	
	private AppUtility(){}
	
	public static void delayExecution() {
		/*try {
	            long time = 9000L;
	            Thread.sleep(time);
	        } catch (InterruptedException e) {
	            throw new IllegalStateException(e);
	        }*/
	}
	
	public static HttpHeaders createHeaders(final String username, final String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

}
