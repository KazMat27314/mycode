package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class MarkToMarketMenu {
	StockList stocklist;

	public MarkToMarketMenu() {
		stocklist = new StockList();
		for (int i = 0; i < stocklist.size(); i++) {
			if ((stocklist.get(i).getAmount() == null) && (stocklist.get(i).getBookValue() == null)) {
				continue;
			} else {
				System.out.println(
						stocklist.get(i).getCode() + ":" + stocklist.get(i).getName() + "の時価を入力してください");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					BigDecimal currentvalue = new BigDecimal(br.readLine());
					stocklist.get(i).setCurrentValue(currentvalue);
					BigDecimal bookvalue = stocklist.get(i).getBookValue();
					BigDecimal amount = stocklist.get(i).getAmount();
					BigDecimal unrealizedprofit = amount.multiply(currentvalue.subtract(bookvalue));
					stocklist.get(i).setUnrealizedProfit(unrealizedprofit);
					
				} catch (IOException e) {
					System.out.print("正しい値を入力してください");
					e.printStackTrace();
				}
			}

		}
		/*try {
			FileWriter file = new FileWriter(
					"/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandBalanceFile");
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));
			for (int i = 0; i < stocklist.size(); i++) {
				pw.println(stocklist.get(i).toString());
			}
			// ファイルを閉じる
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		DaoDB.writeBalance(stocklist);
	}
}
