package com.coderwurst.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class BonnService {

	private static final int HTTP_OK = 200;
	private String stadtBonnParkplatzAPI = "http://www.bcp-bonn.de/stellplatz/bcpinfo.xml";
	
	public String getParkhausInformation() {
		String result = null;
		GetMethod get = new GetMethod(stadtBonnParkplatzAPI);
		
		HttpClient client = new HttpClient();
		
		int responseCode = -1;
		
		try {
			responseCode = client.executeMethod(get);
			if (responseCode == HTTP_OK) {
				result = get.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			result = "Failed to get info from Stadt Bonn. Status Code: " + responseCode;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			get.releaseConnection();
		}
		
		return result;
	}

}
