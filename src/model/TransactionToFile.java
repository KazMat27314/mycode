package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransactionToFile {
	TransactionList transactionList;
	List<String> transactionToFile;
	String code;
	BigDecimal transactionAmount;
	BigDecimal transactionPrice;
	Calendar cal;
	String calToFile;

	TransactionToFile(TransactionList transactionList) {
		transactionToFile = new ArrayList<>();
		for (int i = 0; i < transactionList.size(); i++) {
			code = transactionList.get(i).code;
			transactionAmount = transactionList.get(i).transactionAmount;
			transactionPrice = transactionList.get(i).transactionPrice;
			cal = transactionList.get(i).at;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String calToFile = sdf.format(cal.getTime());
			String data = "code=" + code + ", transactionAmount=" + transactionAmount + ", transactionPrice="
					+ transactionPrice + ", cal=" + calToFile;

			transactionToFile.add(data);

		}
	}
	public int size() {
		return transactionToFile.size();
	}

	public String get(int i) {
		return transactionToFile.get(i);
	}

}
