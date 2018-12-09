package model;

import java.math.BigDecimal;

public class TransactionMenu {
	public TransactionMenu(String code,int buyorsell,BigDecimal transactionprice,BigDecimal transactionamount){
		BigDecimal transactionmoney = transactionprice.multiply(transactionamount);
		
	}
}
