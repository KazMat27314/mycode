package model;

import java.io.IOException;
import java.math.BigDecimal;

public class TransactionMenu {
	String code;
	int buyOrSell;
	BigDecimal transactionPrice;
	BigDecimal transactionAmount;
	BigDecimal transactionMoney;

	public TransactionMenu(String code, int buyOrSell, BigDecimal transactionPrice, BigDecimal transactionAmount)
			throws IOException {
		BigDecimal transactionMoney = transactionPrice.multiply(transactionAmount);
		System.out.println("取引金額は" + transactionMoney);
		StockList stocklist = new StockList();
		switch (buyOrSell) {
		// 売り
		case 1:// amountがnullになる
			if (stocklist.findStock(code).getAmount() == null || stocklist.findStock(code) == null) {
				System.out.println("入力したコードに対応する銘柄は保有していません");
			} else {
				if (stocklist.findStock(code).getAmount().compareTo(transactionAmount) < 0) {
					System.out.println("保有している量を超えて売却しようとしています。もう一度選択してください。");
				} else {
					InventoryInputMenu IIM = new InventoryInputMenu(code, transactionAmount.negate(), transactionPrice);
					System.out.println("売却します");
					System.out.println("実現損益は" + transactionMoney
							.subtract(stocklist.findStock(code).getBookValue().multiply(transactionAmount)));
				}
			}
			break;
		// 買い
		case 2:
			System.out.println("購入します");
			InventoryInputMenu IIM2 = new InventoryInputMenu(code, transactionAmount, transactionPrice);
			break;
		default:

		}
	}
}
