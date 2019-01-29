package be.vdab.groenetenen.web;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

class EuroDollar {
	@NumberFormat
	private final BigDecimal euro;
	@NumberFormat
	private final BigDecimal dollar;
	
	
	public EuroDollar(BigDecimal euro, BigDecimal dollar) {
		super();
		this.euro = euro;
		this.dollar = dollar;
	}


	public BigDecimal getEuro() {
		return euro;
	}


	public BigDecimal getDollar() {
		return dollar;
	}
	
	
	

}