package com.ridebuddy.dao.dynamodb;

import org.springframework.stereotype.Repository;

import com.ridebuddy.dao.RidesDao;
import com.ridebuddy.models.Rides;

@Repository
public class RidesDynamoDbDao extends GenericDynamoDbDao<String, Rides> 
	implements RidesDao {

}
