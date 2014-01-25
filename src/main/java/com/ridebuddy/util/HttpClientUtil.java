package com.ridebuddy.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class HttpClientUtil {
	
	private static final Logger logger = Logger.getLogger(HttpClientUtil.class);

	public String getRequest(String address) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/text");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String content = null;
			while ((content = br.readLine()) != null) {
				sb.append(content);
			}
			conn.disconnect();
		} catch (Exception e) {
			logger.error("Exception while sending GET request to: " + address, e);
			return null;
		}
		return sb.toString();
	}
}
