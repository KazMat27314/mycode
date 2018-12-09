package model;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.StockList;

public class StockListMenu extends JFrame {
	StockList stocklist = new StockList();
	JTable table;
	JScrollPane scroll;

	public StockListMenu() {
		setLayout(new BorderLayout());
		int counter = 0;
		setSize(350, 150);
		setTitle("銘柄一覧");
		stocklist.loadstocks();
		String[] columnNames = { "コード", "名前", "償還年月日", "利率", "クーポン", "保有数量", "簿価", "時価",
				"評価損益" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		add(table.getTableHeader(), BorderLayout.NORTH);
		scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);

		for (int i = 0; i < stocklist.size(); i++) {
			if ((stocklist.get(i).getAmount() == null) || (stocklist.get(i).getBookValue() == null)) {
				continue;
			}
			String code = stocklist.get(i).getCode();
			String name = stocklist.get(i).getName();
			String maturity = String.valueOf(stocklist.get(i).getMaturity());
			String rate = stocklist.get(i).getRate().toString();
			String coupon = String.valueOf(stocklist.get(i).getCoupon());
			String amount = String.valueOf(stocklist.get(i).getAmount().intValue());
			String bookvalue = stocklist.get(i).getBookValue().toString();
			if (stocklist.get(i).getCurrentValue() == null) {

				String na = "#N/A";
				counter++;
				String[] tabledata = { code, name, maturity, rate, coupon, amount, bookvalue, na, na };

				tableModel.addRow(tabledata);
				continue;
			} else {

				String currentvalue = stocklist.get(i).getCurrentValue().toString();
				String unrealizedprofits = String.valueOf(stocklist.get(i).getAmount()
						.multiply(
								stocklist.get(i).getCurrentValue().subtract(stocklist.get(i).getBookValue()))
						.intValue());

				String[] tabledata = { code, name, maturity, rate, coupon, amount, bookvalue, currentvalue,
						unrealizedprofits };
				tableModel.addRow(tabledata);
				continue;
			}
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumn("利率").setCellRenderer(renderer);
		table.getColumn("クーポン").setCellRenderer(renderer);
		table.getColumn("保有数量").setCellRenderer(renderer);
		table.getColumn("簿価").setCellRenderer(renderer);
		if (counter == 1) {
			DefaultTableCellRenderer rend = new DefaultTableCellRenderer();
			rend.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumn("時価").setCellRenderer(rend);
			table.getColumn("評価損益").setCellRenderer(rend);

		} else {
			table.getColumn("時価").setCellRenderer(renderer);
			table.getColumn("評価損益").setCellRenderer(renderer);
		}

	}

}
