package com.ridebuddy.dao;

import java.io.Serializable;
import java.util.List;

import com.ridebuddy.models.Entity;

public interface GenericDao<Id extends Serializable, T extends Entity> {

	public void save(T t);
	
	public List<T> getById(Id id);
	
	public List<T> query(T t);
	
	public void remove(T t);
}
