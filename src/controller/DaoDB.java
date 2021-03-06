package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DaoDB {

	/**
	 * @管理者権限 マスターファイルへの書き込み
	 */
	public void writeMaster() {
		try {
			File file = new File("/Users/userthree/eclipse-workspace/StockManagementSystem/src/BrandMasterFile");

			if (checkBeforeWritefile(file)) {
				FileWriter filewriter = new FileWriter(file, true);
				String stockInfo = UserInput.masterInfoGetter();

				filewriter.write(stockInfo);
				filewriter.write("/n");
				filewriter.close();
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
