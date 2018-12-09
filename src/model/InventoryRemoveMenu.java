package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class InventoryRemoveMenu {
	InventoryRemoveMenu(String code) throws IOException {
		StockList stocklist = new StockList();
	stocklist.loadstocks();
		if (stocklist.findStock(code) != null) {
			stocklist.findStock(code).setAmount(null);
			stocklist.findStock(code).setBookValue(null);
		} else {
			System.out.println("そのコードの銘柄が見つかりません");
		}
		//
		/*try {
			FileWriter file = new FileWriter(
					"/Users/userthree/eclipse-workspace/stocksManagementSystem/src/BrandBalanceFile");
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));
			for (int i = 0; i < stocklist.size(); i++) {
				pw.println(stocklist.get(i).toString());
			}

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		DaoDB.writeBalance(stocklist);
	}
}
