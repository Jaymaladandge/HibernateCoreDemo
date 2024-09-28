package com.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "stud_address")
public class Address {
 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "add_id")
	private int addressId;
	
	
	private String city;
	
	private String state;
	
	private boolean isOpen;
	
	@Transient
	private double count;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	private byte[] image;

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(String city, String state, boolean isOpen, double count, Date addedDate,
			byte[] image) {
		super();
		this.city = city;
		this.state = state;
		this.isOpen = isOpen;
		this.count = count;
		this.addedDate = addedDate;
		this.image = image;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public boolean isOpen() {
		return isOpen;
	}


	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}


	public double getCount() {
		return count;
	}


	public void setCount(double count) {
		this.count = count;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", isOpen=" + isOpen
				+ ", count=" + count + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
}


/*

 The @Temporal annotation in Hibernate is used to specify the precision of date and time values when mapping a Java java.util.Date or java.util.Calendar 
 field to a database column. This annotation helps Hibernate determine whether the date should include just the date, the date with time, 
 or the time with fractional seconds when persisting the entity to the database.
 
 
 As of Java 8, it's recommended to use java.time.LocalDate, java.time.LocalTime, and java.time.LocalDateTime instead of java.util.Date or java.util.Calendar, 
 as they provide better clarity and precision without the need for @Temporal.
 
 
*/









