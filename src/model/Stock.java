package model;

import java.math.BigDecimal;

public class Stock {
	String code;
	String name;
	int maturity;
	BigDecimal rate;
	int coupon;
	BigDecimal amount;
	BigDecimal bookValue;
	BigDecimal currentValue;
	BigDecimal unrealizedProfit;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bookValue == null) ? 0 : bookValue.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + coupon;
		result = prime * result + ((currentValue == null) ? 0 : currentValue.hashCode());
		result = prime * result + maturity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((unrealizedProfit == null) ? 0 : unrealizedProfit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bookValue == null) {
			if (other.bookValue != null)
				return false;
		} else if (!bookValue.equals(other.bookValue))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (coupon != other.coupon)
			return false;
		if (currentValue == null) {
			if (other.currentValue != null)
				return false;
		} else if (!currentValue.equals(other.currentValue))
			return false;
		if (maturity != other.maturity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (unrealizedProfit == null) {
			if (other.unrealizedProfit != null)
				return false;
		} else if (!unrealizedProfit.equals(other.unrealizedProfit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stock [code=" + code + ", name=" + name + ", maturity=" + maturity + ", rate=" + rate + ", coupon="
				+ coupon + ", amount=" + amount + ", bookValue=" + bookValue + ", currentValue=" + currentValue
				+ ", unrealizedProfit=" + unrealizedProfit + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaturity() {
		return maturity;
	}
	public void setMaturity(int maturity) {
		this.maturity = maturity;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getBookValue() {
		return bookValue;
	}
	public void setBookValue(BigDecimal bookValue) {
		this.bookValue = bookValue;
	}
	public BigDecimal getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}
	public BigDecimal getUnrealizedProfit() {
		return unrealizedProfit;
	}
	public void setUnrealizedProfit(BigDecimal unrealizedProfit) {
		this.unrealizedProfit = unrealizedProfit;
	}
	
	

}
