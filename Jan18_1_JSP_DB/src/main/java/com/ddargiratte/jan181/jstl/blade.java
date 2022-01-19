package com.ddargiratte.jan181.jstl;

public class blade {
	
	private String b_location;
	private String b_name;
	private String b_color;
	private String b_gender;
	private int b_person;

	public blade() {
		// TODO Auto-generated constructor stub
	}

	public blade(String b_location, String b_name, String b_color, String b_gender, int b_person) {
		super();
		this.b_location = b_location;
		this.b_name = b_name;
		this.b_color = b_color;
		this.b_gender = b_gender;
		this.b_person = b_person;
	}

	public String getB_location() {
		return b_location;
	}

	public void setB_location(String b_location) {
		this.b_location = b_location;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_color() {
		return b_color;
	}

	public void setB_color(String b_color) {
		this.b_color = b_color;
	}

	public String getB_gender() {
		return b_gender;
	}

	public void setB_gender(String b_gender) {
		this.b_gender = b_gender;
	}

	public int getB_person() {
		return b_person;
	}

	public void setB_person(int b_person) {
		this.b_person = b_person;
	}
	
}