package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StockToFile {
	StockList stocklist;
	List<String> stockToFile;
	String code;
	String name;
	int maturity;
	BigDecimal rate;
	int coupon;
	BigDecimal amount;
	BigDecimal bookValue;
	BigDecimal currentValue;
	BigDecimal unrealizedProfit;

	public void listToMasterFile(StockList stocklist) {
		stockToFile = new ArrayList<>();
		for (int i = 0; i < stocklist.size(); i++) {
			code = stocklist.get(i).code;
			name = stocklist.get(i).name;
			maturity = stocklist.get(i).maturity;
			rate = stocklist.get(i).rate;
			coupon = stocklist.get(i).coupon;
			String data = "code=" + code + ", name=" + name + ", maturity=" + maturity + ", rate=" + rate
					+ ", coupon=" + coupon ;
			stockToFile.add(data);
		}
	}
	
	public void listToBalanceFile(StockList stocklist) {
		stockToFile = new ArrayList<>();
		for (int i = 0; i < stocklist.size(); i++) {
			code = stocklist.get(i).code;
			amount = stocklist.get(i).amount;
			bookValue = stocklist.get(i).bookValue;
			currentValue = stocklist.get(i).currentValue;
			unrealizedProfit = stocklist.get(i).unrealizedProfit;
			String data = "code=" + code + ", amount=" + amount + ", bookValue=" + bookValue + ", currentValue=" + currentValue
					+ ", unrealizedProfit=" + unrealizedProfit ;
			stockToFile.add(data);
		}
	}
	public int size() {
		return stockToFile.size();
	}

	public String get(int i) {
		return stockToFile.get(i);
	}
	

}
