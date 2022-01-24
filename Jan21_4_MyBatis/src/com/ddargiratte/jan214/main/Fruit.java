package com.ddargiratte.jan214.main;

import java.math.BigDecimal;

// MyBatis ORM 발동조건
//		- 멤버변수명, DB컬럼명을 같게!! 해줘야 함
//		- OracleDB에서  ) number타입 - 정수 / 실수
//		- Java에는 정수 / 실수 공용할 수 있는 자료형 - BigDecimal!

// JavaBean, DTO, POJO(Plain Old Java Object)

public class Fruit {
	private String f_name;
	private BigDecimal f_price;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String f_name, BigDecimal f_price) {
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

	public BigDecimal getF_price() {
		return f_price;
	}

	public void setF_price(BigDecimal f_price) {
		this.f_price = f_price;
	}
	
}
