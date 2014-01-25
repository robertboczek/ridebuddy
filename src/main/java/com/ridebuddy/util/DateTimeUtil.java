package com.ridebuddy.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {

	public Date getDate(int addDays) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(new Date()); 
		c.add(Calendar.DATE, addDays);
		return c.getTime();
	}
}
