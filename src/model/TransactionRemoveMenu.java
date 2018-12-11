package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;

public class TransactionRemoveMenu {
	Transaction transaction;
	Calendar calendar;
	TransactionList transactionList;
	FoundTransactions foundTransactions;

	TransactionRemoveMenu(String code ) throws ParseException, IOException {
		calendar = Calendar.getInstance();
		String today = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		transactionList = new TransactionList();
		foundTransactions = transactionList.findTransactions(code);
		int i = 1;
		System.out.println("削除する取引を次から選択してください");
		for (int x = 0; x < foundTransactions.size(); x++) {
			System.out.print(i + ")");
			System.out.println(foundTransactions.get(x).toString());
			i++;
		}
		int option = getOption(foundTransactions);
		System.out.println(foundTransactions.get(option-1)+"を削除します。");
		transactionList.removeTransactions(code);
		foundTransactions.removeTransaction(foundTransactions.get(option-1));
		transactionList.addTransactions(foundTransactions);
		

	}

	public static int getOption(FoundTransactions foundTransactions) throws NumberFormatException, IOException {
		boolean isNum = false;
		int option = 0;
		while (!isNum) {
			// @SuppressWarnings("resource")
			// Scanner scanner = new Scanner(System.in);

			try {
				// option = scanner.nextInt();
				option = Integer.parseInt(getData());
				if (option < 1 || option > foundTransactions.size()) {
					throw new InputMismatchException();
				}
				isNum = true;
				return option;
			} catch (InputMismatchException e) {
				System.out.println("選択肢の数字の中から選んでください");
			}
		}
		return option;
	}

	/**
	 * 在庫データ取得補助(銘柄コード、保有数量、簿価, 銘柄名称、時価）
	 * 
	 * @throws IOException
	 */
	static public String getData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dataInfo = br.readLine();
		return dataInfo;
	}

}
