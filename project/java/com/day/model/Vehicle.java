package com.day.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Component
@Entity
@Table(name="Vehicle")
public class Vehicle {
	@Id
	String vehicle_no;
	float amount;
	Date date_from;
	LocalTime from_time;
	Date date_to;
	LocalTime to_time;
	String owner_name;
	
	
	@Transient
	int d1,d2,h1,h2;
	
	@Override
	public String toString() {
		return "Vehicle [vehicle_no=" + vehicle_no + ", amount=" + amount + ", date_from=" + date_from + 
				", date_to=" + date_to + ", from_time="
				+ from_time +  ", to_time=" + to_time + ", owner_name=" + owner_name + "]";
	}
	
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public Date getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {		
		Date d= Date.valueOf(date_from);
		LocalDate cur=LocalDate.parse(date_from);
		this.d1=cur.getDayOfMonth();
		this.date_from = d;	
	}
	public Date getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		Date d0= Date.valueOf(date_to);
		LocalDate cur=LocalDate.parse(date_to);
		this.d2=cur.getDayOfMonth();
		this.date_to = d0;
	}
	public LocalTime getFrom_time() {
		return from_time;
	}
	public void setFrom_time(LocalTime from_time) {
		this.h1=from_time.getHour();
		this.from_time = from_time;
	}
	public LocalTime getTo_time() {
		return to_time;
	}
	public void setTo_time(LocalTime to_time) {
		this.h2=to_time.getHour();
		this.to_time = to_time;
		
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount() {
		float a;
		int h=h1-h2;
		int d=d1-d2;
		if(d==0)
		{
			if(h==0)
			{
				a=20;
			}
			else {
				a=h*20;
			}
		}
		else if(h==0){a=d*20;}
		else {a=d*h*20;}
		this.amount=a;
	}
	
}

