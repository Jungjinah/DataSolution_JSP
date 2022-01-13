package com.ddargiratte.jan132.main;

public class Patient {
	private String name;
	private int age;
	private double height;
	private double weight;
	private String result;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, int age, double height, double weight, String result) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}