package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DaoDB {

	/**
	 * @管理者権限 マスターファイルへの書き込み
	 */
	public static void writeMaster(StockList stocklist) {
		try {
			StockToFile stockToFile = new StockToFile();
			File file = new File("/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandMasterFile");
			stockToFile.listToMasterFile(stocklist);
			if (checkBeforeWritefile(file)) {
				/*
				 * FileWriter filewriter = new FileWriter(file, true);
				 * filewriter.write(stockToFile.toString()); filewriter.write("/n");
				 * filewriter.close();
				 */
				FileWriter fileWriter = new FileWriter(file);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fileWriter));
				for (int i = 0; i < stockToFile.size(); i++) {
					pw.println(stockToFile.get(i));
				}
				pw.close();
			} else {
				System.out.println("エラー！　管理者に問い合わせください");
				System.out.println("エラー番号:DaoWriter.writeMaster/File Error");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * @管理者権限 ブランドファイルへの書き込み
	 */
	public static void writeBalance(StockList stocklist) {
		try {
			StockToFile stockToFile = new StockToFile();
			
			File file = new File("/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandBalanceFile");
			stockToFile.listToBalanceFile(stocklist);
			
			if (checkBeforeWritefile(file)) {
				/*
				 * FileWriter filewriter = new FileWriter(file, true);
				 * filewriter.write(stockToFile.toString()); filewriter.write("/n");
				 * filewriter.close();
				 */
				FileWriter fileWriter = new FileWriter(file);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fileWriter));
				for (int i = 0; i < stockToFile.size(); i++) {
					pw.println(stockToFile.get(i));
				}
				pw.close();
			} else {
				System.out.println("エラー！　管理者に問い合わせください");
				System.out.println("エラー番号:DaoWriter.writeMaster/File Error");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 指定されたファイルが存在していて書き込み可能か確認
	 * 
	 * @param file
	 * @return
	 */
	static private boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}
}
