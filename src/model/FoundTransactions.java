package model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class FoundTransactions {
	List<Transaction> foundTransactions;
	Transaction transaction;

	FoundTransactions() {

	}

	public void addTransaction(Transaction transaction) {
		foundTransactions.add(transaction);
	}

	public Transaction findFoundTransaction(BigDecimal transactionAmount, BigDecimal transactionPrice, Calendar cal) {
		for (int i = 0; i < foundTransactions.size(); i++) {
			if (transactionAmount.equals(foundTransactions.get(i).getTransactionAmount())
					&& transactionAmount.equals(foundTransactions.get(i).getTransactionAmount())
					&& cal.equals(foundTransactions.get(i).getAt())) {
				transaction = foundTransactions.get(i);
				return transaction;
			}
		}
		return null;
	}

	public void removeTransaction(BigDecimal transactionAmount, BigDecimal transactionPrice, Calendar cal) {
		transaction = findFoundTransaction(transactionAmount, transactionPrice, cal);
		foundTransactions.remove(transaction);
	}
	public void removeTransaction(Transaction transaction) {
		foundTransactions.remove(transaction);
	}
	

	public int size() {
		return foundTransactions.size();
	}

	public Transaction get(int i) {
		return foundTransactions.get(i);
	}

}
