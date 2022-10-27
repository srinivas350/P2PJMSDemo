package com.example.model;

import java.io.Serializable;

public class patient implements Serializable{

	private int id;
	 private String name;
	double paymentdone;
	double payDue;
	
	public patient() {
		// TODO Auto-generated constructor stub
	}

		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPaymentString() {
		return paymentdone;
	}
	public void setPaymentString(double paymentString) {
		this.paymentdone = paymentString;
	}
	public double getPayDue() {
		return payDue;
	}
	public void setPayDue(double payDue) {
		this.payDue = payDue;
	}

	
}
