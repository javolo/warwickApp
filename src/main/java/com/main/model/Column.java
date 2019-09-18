package com.main.model;

import java.math.BigDecimal;

public class Column {
	
	public int colNumber = 0;
	public BigDecimal number;
	
	public Column (final int colNumberIn, final BigDecimal numberIn) {
		this.colNumber = colNumberIn;
		this.number = numberIn;
	}
	
	/**
	 * @return the colNumber
	 */
	public int getColNumber() {
		return colNumber;
	}
	
	/**
	 * @param colNumber the colNumber to set
	 */
	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}
	
	/**
	 * @return the number
	 */
	public BigDecimal getNumber() {
		return number;
	}
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}

}
