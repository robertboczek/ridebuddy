package com.ridebuddy.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperUtil {

	private static final Logger logger = Logger.getLogger(ObjectMapperUtil.class);
	private ObjectMapper objectMapper;
	
	public <T> T readValue(String json, Class<T> cl) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		try {
			return objectMapper.readValue(json, cl);
		} catch (IOException e) {
			logger.error("Exception while mapping json", e);
			return null;
		}
	}
}
