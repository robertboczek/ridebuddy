package com.ridebuddy.aws;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.dynamodb.AmazonDynamoDBClient;

@Component
public class DynamoDbClientProvider {
	
	private static final Logger logger = Logger
			.getLogger(DynamoDbClientProvider.class);
	
	private static final String endpoint = "dynamodb.us-east-1.amazonaws.com";
	private static volatile AmazonDynamoDBClient client;

	public AmazonDynamoDBClient getClient() throws Exception {
		if (client == null) {
			synchronized (DynamoDbClientProvider.class) {
				if (client == null) {
					InputStream is = this.getClass().getResourceAsStream("/awsCredentials.properties");
					if (is != null) {
						AWSCredentials credentials = new PropertiesCredentials(is);
						client = new AmazonDynamoDBClient(credentials);
						client.setEndpoint(endpoint);
					}
				}
			}
		}
		return client;
	}
}
