package Operation;

import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class TableFitColumn {

	// 自动设置列宽
	public static void fitTableColumns(JTable table) {
		JTableHeader header = table.getTableHeader();
		int rowCount = table.getRowCount();
		Enumeration columns = table.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			javax.swing.table.TableColumn column = (javax.swing.table.TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int) table.getTableHeader().getDefaultRenderer()
					.getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();
			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) table.getCellRenderer(row, col)
						.getTableCellRendererComponent(table, table.getValueAt(row, col), false, false, row, col)
						.getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column); // 此行很重要
			column.setWidth(width + table.getIntercellSpacing().width);
		}
	}

	// 手动设置列宽
	public static void fitTableColumns(JTable table, int[] columnWidths) {
		for (int i = 0; i < columnWidths.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
		}
	}
}
