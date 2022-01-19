package com.ddargiratte.jan193.fruit;

public class Fruit {
	private String f_name;
	private int f_price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String f_name, int f_price) {
		super();
		this.f_name = f_name;
		this.f_price = f_price;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public int getF_price() {
		return f_price;
	}

	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	
}