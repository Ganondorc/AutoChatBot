/*
 * Name: Michael Frake
 * Project: CMSC 3 Project 1
 * Date: Feb 28, 2022
 * Description: 
 */
package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	public final String messageType = "RESPONSE";
	
	private final static long PAGE_ID = 1;
	private final static long APP_ID = 990972418205362L;
	private final static String PAGE_ACCESS_TOKEN = "";
	private final static String APP_SECRET = "0853717da6153b4046b4691572324f75";
	
	// universal resource identifier
	private final static String URI = "https://graph.facebook.com/v13.0/me/messages?access_token=" + PAGE_ACCESS_TOKEN;
	private String output;
	
	public Main() {
		output = "'{" + 
					"\"messaging_type\": \"<MESSAGING_TYPE>\"," + 
					"\"recipient\": {" + 
						"\"id\": \"<PSID>\"" + 
					"}," + 
					"\"message\": {" + 
						"\"text\": \"hello, world!\"" + 
					"}" + 
				"}'";
	}
	public static void main(String[] args) {
		try {
			URL url = new URL(URI);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type","application/json");
			http.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(new Main().output);
			wr.flush();
			wr.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
