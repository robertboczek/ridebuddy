package com.ridebuddy.dao.dynamodb;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBMapper;
import com.ridebuddy.aws.DynamoDbClientProvider;
import com.ridebuddy.dao.GenericDao;
import com.ridebuddy.models.Entity;


public abstract class GenericDynamoDbDao<Id extends Serializable, T extends Entity> 
	implements GenericDao<Id, T>
{
	private static final Logger logger = Logger.getLogger(GenericDynamoDbDao.class);
	
	@Autowired
	protected DynamoDbClientProvider clientProvider;

	private Class<T> entityClass;
	
	private static volatile DynamoDBMapper dbMapper;
	
	public GenericDynamoDbDao() {
		this.entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected DynamoDBMapper getDynamoDbMapper()
	{
		if (dbMapper == null) {
			synchronized (GenericDynamoDbDao.class) {
				try {
					dbMapper = new DynamoDBMapper(clientProvider.getClient());
				} catch (Exception e) {
					logger.error("Exception while creating dynamoDBMapper", e);
				}
			}
		}
		return dbMapper;
	}

	public void save(T t) {
		if (t == null) {
			throw new IllegalArgumentException("Cannot save null argument");
		}
		getDynamoDbMapper().save(t);
	}

	public List<T> getById(Id id) {
		if (id == null) {
			throw new IllegalArgumentException("Id can't be null");
		}
		T t = getDynamoDbMapper().load(entityClass, id);
		List<T> entities = new ArrayList<T>();
		if (t != null) {
			entities.add(t);
		}
		return entities;
	}

	public List<T> query(T t) {
		return null;
	}

	public void remove(T t) {
		getDynamoDbMapper().delete(t);
	}
}
