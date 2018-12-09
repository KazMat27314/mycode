package model;

import java.io.IOException;
import java.math.BigDecimal;

public class MainMenu {
	public static void main(String[] args) throws IOException {

		//BigDecimal big = BigDecimal.valueOf(18);
		//BigDecimal dec = BigDecimal.valueOf(34);
		//InventoryInputMenu inventory = new InventoryInputMenu("89723",big,dec);
		//MarkToMarketMenu mtmm = new MarkToMarketMenu();
	    StockListMenu app = new StockListMenu();
        app.setVisible(true);
        
	}
}
