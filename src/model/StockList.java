package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StockList {

	List<Stock> stocklist;
	Stock stock;

	StockList() {
		stocklist = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandMasterFile"));
			String str;
			while ((str = reader.readLine()) != null) {
	
				Stock stock = new Stock();
				Pattern p = Pattern.compile("[,\\=]");
				String[] info = p.split(str);
				stock.setCode(info[1]);
				stock.setName(info[3]);
				int maturity = Integer.parseInt(info[5]);
				stock.setMaturity(maturity);
				BigDecimal rate = new BigDecimal(info[7]);
				stock.setRate(rate);
				int coupon = Integer.parseInt(info[9]);
				stock.setCoupon(coupon);
				
				try (BufferedReader read = new BufferedReader(new FileReader(
						"/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandBalanceFile"));) {
					String string;
					
					while ((string = read.readLine()) != null) {
						// String[] infoma = string.split(",");
						Pattern pa = Pattern.compile("[,\\=]");
						String[] infoma = pa.split(string);
						
						if (infoma[1].equals(info[1])) {
							if (!(infoma[3].equals("null")) && !(infoma[5].equals("null"))) {
								BigDecimal infoa = new BigDecimal(infoma[3]);
								BigDecimal infob = new BigDecimal(infoma[5]);

								stock.setAmount(infoa);
								stock.setBookValue(infob);
								
								if (!(infoma[7].equals("null"))) {
									BigDecimal infoc = new BigDecimal(infoma[7]);
									BigDecimal infod = infoa.multiply(infob.subtract(infoc));
									stock.setCurrentValue(infoc);
									stock.setUnrealizedProfit(infod);
								}
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				addStock(stock);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}

	public void addStock(Stock stock) {
		if (findStock(stock.getCode()) == null) {
			stocklist.add(stock);
		} else {
			stocklist.remove(findStock(stock.getCode()));
			stocklist.add(stock);
		}
	}

	public Stock findStock(String code) {
		for (int i = 0; i < stocklist.size(); i++) {
			if (code.equals(stocklist.get(i).getCode())) {
				stock = stocklist.get(i);
				return stock;
			}
		}
		return null;
	}

	public void removestock(String code) {
		stock = findStock(code);
		stocklist.remove(stock);
	}

	public int size() {
		return stocklist.size();
	}

	public Stock get(int i) {
		return stocklist.get(i);
	}

	public void loadstocks() {

	}
}
