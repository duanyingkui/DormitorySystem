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

import ButtonFrame.GradeSearch;
import ButtonFrame.StudentSearch;
import ButtonFrame.GradeSearch;
import Control.GradeControl;
import Model.GradeModel;
import Operation.TableFitColumn;

public class GradeTable {
	public static JPanel jp = new JPanel();
	private DefaultTableModel model;
	Object columnNames[] = { "宿舍编号", "宿舍号", "纪律", "考勤", "卫生", "总分", "评分时间", "评分人" };

	public GradeTable() {
		Object data[][] = null;
		JTable jt;
		JScrollPane js = new JScrollPane();
		GradeControl dormcontrol = new GradeControl();
		List<GradeModel> result;
		try {
			result = dormcontrol.query();
			data = new Object[result.size()][11];
			int j = 0;
			for (int i = 0; i < result.size(); i++) {
				data[i][j] = result.get(i).getGrade_id();
				j++;
				data[i][j] = result.get(i).getDorm_id();
				j++;
				data[i][j] = result.get(i).getDiscipline();
				j++;
				data[i][j] = result.get(i).getChecks();
				j++;
				data[i][j] = result.get(i).getHealth();
				j++;
				data[i][j] = result.get(i).getGrade();
				j++;
				data[i][j] = result.get(i).getDates();
				j++;
				data[i][j] = result.get(i).getManagers_id();
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
		jt = new JTable(model);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		jt.setRowHeight(25);
		jt.setEnabled(false);
		js.setViewportView(jt);
		jp.add(js);

		jp.setVisible(false);
		jp.setBounds(220, 50, 715, 465);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 400));
	}

	public JPanel getpanel() {
		return jp;
	}

}
