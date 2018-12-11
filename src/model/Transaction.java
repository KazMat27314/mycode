package model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class Transaction {
	String code;
	BigDecimal transactionAmount;
	BigDecimal transactionPrice;
	Calendar at;
	
	public Transaction(String code, BigDecimal transactionAmount, BigDecimal transactionPrice) {
		this.at= at.getInstance();
		this.code =code;
		this.transactionAmount = transactionAmount;
		this.transactionPrice = transactionPrice;
	}
	public Transaction(String code, BigDecimal transactionAmount, BigDecimal transactionPrice, Calendar cal) {
		this.at = cal;
		this.code =code;
		this.transactionAmount = transactionAmount;
		this.transactionPrice = transactionPrice;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the transactionAmount
	 */
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	/**
	 * @return the transactionPrice
	 */
	public BigDecimal getTransactionPrice() {
		return transactionPrice;
	}
	/**
	 * @param transactionPrice the transactionPrice to set
	 */
	public void setTransactionPrice(BigDecimal transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	/**
	 * @return the at
	 */
	public Calendar getAt() {
		return at;
	}
	/**
	 * @param at the at to set
	 */
	public void setAt(Calendar at) {
		this.at = at;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(at, code, transactionAmount, transactionPrice);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Transaction other = (Transaction) obj;
		return Objects.equals(at, other.at) && Objects.equals(code, other.code)
				&& Objects.equals(transactionAmount, other.transactionAmount)
				&& Objects.equals(transactionPrice, other.transactionPrice);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [code=" + code + ", transactionAmount=" + transactionAmount + ", transactionPrice="
				+ transactionPrice + ", at=" + at + "]";
	}
}
	
