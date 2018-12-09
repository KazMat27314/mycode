package controller;
import java.io.IOException;

import model.DaoFile;
import view.ConsoleOutPut;

public class Test {

	static public void main(String args[]) throws IOException {
		/*ConsoleOutPut.showMenu();
		
		UserInput  ob = new UserInput();
		System.out.print(ob.getStockData());
		System.out.print(ob.getOption());
		DaoDB oo = new DaoDB();
		oo.writeMaster();
		
		DaoFile write = new DaoFile();
		write.writeMaster(null);
		*/
		
		UserInput ui = new UserInput();
		ui.Main();
	}
	
}
