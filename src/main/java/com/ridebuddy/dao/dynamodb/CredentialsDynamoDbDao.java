package com.ridebuddy.dao.dynamodb;

import org.springframework.stereotype.Repository;

import com.ridebuddy.dao.CredentialsDao;
import com.ridebuddy.models.Credentials;

@Repository
public class CredentialsDynamoDbDao extends GenericDynamoDbDao<String, Credentials> 
	implements CredentialsDao {
	
}
