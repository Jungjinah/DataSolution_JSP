package com.ddargiratte.jan201.member;

import java.util.Date;

public class Member {
	private String l_id;
	private String l_pw;
	private String l_name;
	private int l_phoneNumber;
	private Date l_birthday;
	private String l_gender;
	private String l_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String l_id, String l_pw, String l_name, int l_phoneNumber, Date l_birthday, String l_gender,
			String l_photo) {
		super();
		this.l_id = l_id;
		this.l_pw = l_pw;
		this.l_name = l_name;
		this.l_phoneNumber = l_phoneNumber;
		this.l_birthday = l_birthday;
		this.l_gender = l_gender;
		this.l_photo = l_photo;
	}

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getL_pw() {
		return l_pw;
	}

	public void setL_pw(String l_pw) {
		this.l_pw = l_pw;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getL_phoneNumber() {
		return l_phoneNumber;
	}

	public void setL_phoneNumber(int l_phoneNumber) {
		this.l_phoneNumber = l_phoneNumber;
	}

	public Date getL_birthday() {
		return l_birthday;
	}

	public void setL_birthday(Date l_birthday) {
		this.l_birthday = l_birthday;
	}

	public String getL_gender() {
		return l_gender;
	}

	public void setL_gender(String l_gender) {
		this.l_gender = l_gender;
	}

	public String getL_photo() {
		return l_photo;
	}

	public void setL_photo(String l_photo) {
		this.l_photo = l_photo;
	}
	
}