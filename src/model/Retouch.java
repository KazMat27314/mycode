package model;

public class Retouch {

	/**
	 * 
	 * Fileマスターファイルに書き込み用に加工(StockToFile)
	 * 
	 * 
	 */
	public void writeToFile() {

		StockToFile stockToFile = new StockToFile();

		stockToFile.setCode(null);
		stockToFile.setCoupon(null);
		stockToFile.setName(null);
		stockToFile.setRate(null);
		stockToFile.setMaturity(null);

		// DaoFile.writeMaster(stockToFile);

	}

	/**
	 * 
	 * DBマスターファイルに書き込み用(StockToFile)
	 * 
	 * 
	 */
	public void writeToDB() {
		StockToFile stockToFile = new StockToFile();

		stockToFile.setCode(null);
		stockToFile.setCoupon(null);
		stockToFile.setName(null);
		stockToFile.setRate(null);
		stockToFile.setMaturity(null);
	}

}
