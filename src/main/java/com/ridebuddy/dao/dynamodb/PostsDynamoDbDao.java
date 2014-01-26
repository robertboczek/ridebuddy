package com.ridebuddy.dao.dynamodb;

import org.springframework.stereotype.Repository;

import com.ridebuddy.dao.PostsDao;
import com.ridebuddy.models.Posts;

@Repository
public class PostsDynamoDbDao extends GenericDynamoDbDao<String, Posts> 
	implements PostsDao {

}
