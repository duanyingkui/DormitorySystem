package TableStudent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ButtonFrame.StudentSearchManager;
import Control.ManagerControl;
import Model.ManagersModel;

public class ManagerTable {
	Object columnNames[] = { "姓名", "员工号", "联系方式" };
	public static JPanel jp = new JPanel();
	private DefaultTableModel model;
	JButton Search_Button;

	public ManagerTable() {
		Search_Button = new JButton("查询");

		Object data[][] = null;
		JTable jt;
		JScrollPane js = new JScrollPane();
		ManagerControl managercontrol = new ManagerControl();
		List<ManagersModel> result;
		try {
			result = managercontrol.query();
			data = new Object[result.size()][3];
			int j = 0;
			for (int i = 0; i < result.size(); i++) {
				data[i][j] = result.get(i).getManager_name();
				j++;
				data[i][j] = result.get(i).getManager_id();
				j++;
				data[i][j] = result.get(i).getContact();
				j = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model = new DefaultTableModel(data, columnNames);
		jt = new JTable(model);
		// TableFitColumn.fitTableColumns(jt);
		jt.setEnabled(false);
		// jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		js.setViewportView(jt);
		jt.setRowHeight(25);
		jp.add(js);

		Search_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Search_Button) {
					new StudentSearchManager();
				}

			}
		});
		jp.add(Search_Button);

		jp.setVisible(false);
		jp.setBounds(220, 50, 715, 465);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 400));

	}

	public JPanel getpanel() {
		return jp;
	}

}
