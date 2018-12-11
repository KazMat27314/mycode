package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class TransactionList {
	List<Transaction> transactionList;
	Transaction transaction;
	FoundTransactions foundTransactions;

	public TransactionList() throws ParseException {
		transactionList = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("/Users/userthree/eclipse-workspace/StockManagementSystem/src/TransactionFile"));
			String str;
			while ((str = reader.readLine()) != null) {

				Pattern p = Pattern.compile("[,\\=]");
				String[] info = p.split(str);
				String code = info[1];
				BigDecimal transactionAmount = new BigDecimal(info[3]);
				BigDecimal transactionPrice = new BigDecimal(info[5]);
				String datacal = info[7];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				Date date = sdf.parse(datacal);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				transaction = new Transaction(code, transactionAmount, transactionPrice, cal);
				transactionList.add(transaction);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addTransactions(FoundTransactions foundTransactions) {
		for (int i = 0; i < foundTransactions.size(); i++) {
			transactionList.add(foundTransactions.get(i));
		}
	}

	public FoundTransactions findTransactions(String code) {
		Calendar calendar = Calendar.getInstance();
		String today = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		for (int i = 0; i < transactionList.size(); i++) {
			if (code.equals(transactionList.get(i).getCode())&&new SimpleDateFormat("yyyyMMdd").format(transactionList.get(i).getAt().getTime()).equals(today)) {
				transaction = transactionList.get(i);
				foundTransactions.addTransaction(transaction);
			}
		}
		return foundTransactions;
	}

	public void removeTransactions(String code) {
		foundTransactions = findTransactions(code);
		for (int i = 0; i < foundTransactions.size(); i++) {
			transaction = foundTransactions.get(i);
			transactionList.remove(transaction);
		}
	}

	public int size() {
		return transactionList.size();
	}

	public Transaction get(int i) {
		return transactionList.get(i);
	}

}
