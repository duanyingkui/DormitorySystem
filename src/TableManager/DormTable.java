package TableManager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ButtonFrame.DormSearch;
import Control.DormControl;
import Model.DormModel;

public class DormTable {
	public Object data[][] = null;
	Object columnNames[] = { "宿舍号", "床位", "人数" };
	public static JPanel jp = new JPanel();
	private DefaultTableModel model;

	JButton Search_Button;
	JScrollPane js = new JScrollPane();
	JTable jt;

	public DormTable() {
		Search_Button = new JButton("查询");
		jt = new JTable(model);
		jt = new JTable(querydorm());
		jt.setVisible(true);
		;
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		jt.setRowHeight(25);
		jt.setEnabled(true);
		js.setViewportView(jt);
		jp.add(js);

		Search_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Search_Button) {
					new DormSearch();

				}

			}
		});
		jp.add(Search_Button);

		jp.setVisible(false);
		jp.setBounds(220, 50, 720, 465);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 400));
	}

	public JPanel getpanel() {
		return jp;
	}

	public DefaultTableModel querydorm() {
		DormControl dormcontrol = new DormControl();
		List<DormModel> result;
		try {
			result = dormcontrol.query();
			data = new Object[result.size()][11];
			int j = 0;
			for (int i = 0; i < result.size(); i++) {
				data[i][j] = result.get(i).getDorm_id();
				j++;
				data[i][j] = result.get(i).getBed_num();
				j++;
				data[i][j] = result.get(i).getPeople_num();
				j = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}
