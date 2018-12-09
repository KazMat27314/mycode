package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InventoryInputMenu {
	public InventoryInputMenu(String code, BigDecimal amount, BigDecimal bookValue) throws IOException {
		StockList stocklist = new StockList();
		
		//why did it do well?
		
		if (stocklist.findStock(code) != null) {

			stocklist.findStock(code).setAmount(amount);
			stocklist.findStock(code).setBookValue(bookValue);
			
		}else {
			System.out.println("該当する銘柄はありません");
		}
		/*try {
			FileWriter file = new FileWriter(
					"/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandBalanceFile");
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));
			for (int i = 0; i < stocklist.size(); i++) {
				pw.println(stocklist.get(i).toString());
			}
			System.out.print("s");
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("s");
		}
		*/
		
		DaoDB.writeBalance(stocklist);
		
	}
	public InventoryInputMenu(String code,String name, int maturity, BigDecimal rate,int coupon){
		StockList stocklist = new StockList();
		Stock stock = new Stock();
		stock.setCode(code);
		stock.setName(name);
		stock.setMaturity(maturity);
		stock.setRate(rate);
		stock.setCoupon(coupon);
		stocklist.addStock(stock);
		DaoDB.writeMaster(stocklist);
		DaoDB.writeBalance(stocklist);
	}
}
