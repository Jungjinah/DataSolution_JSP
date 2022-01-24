package com.ddargiratte.jan215.memo;

import java.math.BigDecimal;
import java.util.Date;

public class Memo {
	private BigDecimal m_no;
	private String m_text;
	private Date m_date;
	
	public Memo() {
		// TODO Auto-generated constructor stub
	}

	public Memo(BigDecimal m_no, String m_text, Date m_date) {
		super();
		this.m_no = m_no;
		this.m_text = m_text;
		this.m_date = m_date;
	}

	public BigDecimal getM_no() {
		return m_no;
	}

	public void setM_no(BigDecimal m_no) {
		this.m_no = m_no;
	}

	public String getM_text() {
		return m_text;
	}

	public void setM_text(String m_text) {
		this.m_text = m_text;
	}

	public Date getM_date() {
		return m_date;
	}

	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	
}
