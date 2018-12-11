package view;

public class ConsoleOutPut {

	
	
	/**
	 * 初期画面の選択肢選択を表示させる
	 */
	static public void showMenu() {
		System.out.println(" ***  選択肢を選んでください。*** ");
		System.out.println("1) 在庫データの入力");
		System.out.println("2) 当日の値洗い");
		System.out.println("3) マスターファイルに追加");
		System.out.println("4) 保有銘柄残高一覧");
		System.out.println("5) 取引");
		
		System.out.print("選択肢　＞　");
	}
	
	/**
	 * ユーザーが選択肢選択後の処理表示
	 * @param option	初期画面選択肢
	 */
	static public void showSelectedMenu(int option) {
		switch (option) {
		case 1:
			System.out.println("在庫データの入力オプションが選択されました。 ");
			break;
		case 2:
			System.out.println("当日の値洗いオプションが選択されました。");
			break;
		case 3:
			System.out.println("マスターファイルに追加が選択されました。");
			break;
		case 4:
			System.out.println("保有銘柄残高一覧を表示します。");
			break;
		case 5:
			System.out.println("取引を開始します。");
			break;
		default:
			System.out.println("選択肢は１〜５です！");
		}
	}
	/**
	 * 取引データ入力フォーム
	 * @param option	債券データの種類
	 */
	static public void transactionInfoGetterMenu(int option) {
		switch (option) {
		case 1:
			System.out.println("銘柄コードを入力してください");
			System.out.print("銘柄コード< ");
			break;
		case 2:
			System.out.println("取引価格を入力してください");
			System.out.print("取引価格< ");
			break;
		case 3:
			System.out.println("取引数量を入力してください");
			System.out.print("取引数量< ");
			break;
		case 4:
			System.out.println("1:売り  2:買い　どちらか選択してください");
			System.out.print("売買< ");
			break;
		default:
			System.out.println("エラー番号: ConsoleOutPut.masterInfoGetter/Option Error");
		}
	}
	/**
	 * 債券データ入力フォーム
	 * @param option	債券データの種類
	 */
	static public void stockInfoGetterMenu(int option) {
		switch (option) {
		case 1:
			System.out.println("銘柄コードを入力してください");
			System.out.print("銘柄コード< ");
			break;
		case 2:
			System.out.println("銘柄名を入力してください");
			System.out.print("銘柄名< ");
			break;
		case 3:
			System.out.println("償還年月日を入力してください");
			System.out.print("償還年月日< ");
			break;
		case 4:
			System.out.println("利率を入力してください");
			System.out.print("利率< ");
			break;
		case 5:
			System.out.println("クーポン利用回数を入力してください");
			System.out.print("クーポン利用回数< ");
			break;
		case 6:
			System.out.println("保有数量を入力してください");
			System.out.print("保有数量< ");
			break;
		case 7:
			System.out.println("簿価を入力してください");
			System.out.print("簿価< ");
			break;
		default:
			System.out.println("エラー番号: ConsoleOutPut.masterInfoGetter/Option Error");
		}
	}
	
	static public void transactionPrinter(int transactionOption) {
		System.out.println("取引を開始します");
		switch (transactionOption) {
		case 1:
			System.out.println("売り取引をします");
			break;
		case 2:
			System.out.println("購入します");
			break;
		default:
			System.out.println("エラー番号: ConsoleOutPut.errorMessagePrinter");
		}
	}
	static public void errorMessagePrinter(int fileOption) {
		System.out.println("エラー！　管理者に問い合わせください");
		switch (fileOption) {
		case 1:
			System.out.println("エラー番号: ConsoleOutPut.masterInfoGetter/Option Error");
			break;
		default:
			System.out.println("エラー番号: ConsoleOutPut.errorMessagePrinter");
		}
	}
}
