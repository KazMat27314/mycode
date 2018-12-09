package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.InventoryInputMenu;
import model.MarkToMarketMenu;
import model.StockListMenu;
import view.ConsoleOutPut;

public class UserInput {

	/**
	 * メニュー画面の選択入力補助
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 * @throws InputMismatchException
	 */
	public static int getOption() throws NumberFormatException, IOException {
		boolean isNum = false;
		int option = 0;
		while (!isNum) {
			//@SuppressWarnings("resource")
			//Scanner scanner = new Scanner(System.in);
			
			try {
				//option = scanner.nextInt();
				option = Integer.parseInt(getData());
				if (option < 1 || option > 5) {
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
	 * 在庫データ取得(銘柄コード、保有数量、簿価を取得）
	 * 
	 * @throws IOException
	 */
	public static String getBalanceData() throws IOException {

		ConsoleOutPut.stockInfoGetterMenu(1);
		String code = getData();

		ConsoleOutPut.stockInfoGetterMenu(6);
		String amount = getData();

		ConsoleOutPut.stockInfoGetterMenu(7);
		String bookValue = getData();

		String balanceData = "code=" + code + ",amount=" + amount + ",bookValue=" + bookValue;
		System.out.println("以下の情報が在庫ファイルに書き込まれます。");
		System.out.println(balanceData);
		return balanceData;

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

	/**
	 * マスターファイルに書き込む用のデータをユーザーから取得する。
	 * 
	 * @return
	 * @throws IOException
	 */
	static public String getMasterData() throws IOException {
		System.out.println("マスターファイルに書き込む債券の情報を入力してください。");

		ConsoleOutPut.stockInfoGetterMenu(1);
		String code = UserInput.getData();
		ConsoleOutPut.stockInfoGetterMenu(2);
		String name = UserInput.getData();
		ConsoleOutPut.stockInfoGetterMenu(3);
		String maturity = UserInput.getData();
		ConsoleOutPut.stockInfoGetterMenu(4);
		String rate = UserInput.getData();
		ConsoleOutPut.stockInfoGetterMenu(5);
		String coupon = UserInput.getData();

		String masterData = "code="+code + ",name=" + name + ",maturity=" + maturity + ",rate=" + rate + ",coupon=" + coupon;
		System.out.println("以下の情報がマスターファイルに書き込まれます。");
		System.out.println(masterData);

		return masterData;
	}

	static public void Main() throws IOException {
		ConsoleOutPut.showMenu();
		int option = getOption();
		ConsoleOutPut.showSelectedMenu(option);
		switch (option) {
		case 1:
			Pattern p = Pattern.compile("[,\\=]");
			String[] info = p.split(getBalanceData());
			InventoryInputMenu IIM = new InventoryInputMenu(info[1],new BigDecimal(info[3]),new BigDecimal(info[5]));
			break;
		case 2:
			MarkToMarketMenu MTMM = new MarkToMarketMenu();
			break;
		case 3:
			Pattern pa = Pattern.compile("[,\\=]");
			String[] infoma = pa.split(getMasterData());
			InventoryInputMenu IIM2 =new InventoryInputMenu(infoma[1],infoma[3],Integer.parseInt(infoma[5]),new BigDecimal(infoma[7]),Integer.parseInt(infoma[9]));
			break;
		case 4:
			StockListMenu app = new StockListMenu();
	        app.setVisible(true);
			break;
		default:
		}
	}

}
