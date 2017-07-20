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

import ButtonFrame.PartStudentSearch;
import Control.StudentsControl;
import Model.StudentsModel;
import Operation.TableFitColumn;

public class PartStudentTable {

	Object columnNames[] = { "姓名", "性别", "联系方式", "学号", "学院", "班级", "宿舍号", "床号" };
	public static JPanel jp = new JPanel();
	private DefaultTableModel model; // 零行零列的表
	JButton Search_Button;

	public PartStudentTable() {
		Search_Button = new JButton("查询");
		Object data[][] = null;
		JTable jt;
		JScrollPane js = new JScrollPane();
		StudentsControl studentcontrol = new StudentsControl();
		List<StudentsModel> result;
		try {
			result = studentcontrol.all();
			data = new Object[result.size()][8];
			int j = 0;
			for (int i = 0; i < result.size(); i++) {
				data[i][j] = result.get(i).getName();
				j++;
				data[i][j] = result.get(i).getSex();
				j++;
				data[i][j] = result.get(i).getContact();
				j++;
				data[i][j] = result.get(i).getStudent_id();
				j++;
				data[i][j] = result.get(i).getCollege();
				j++;
				data[i][j] = result.get(i).getClasses();
				j++;
				data[i][j] = result.get(i).getDorm_id();
				j++;
				data[i][j] = result.get(i).getBed_id();
				j = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model = new DefaultTableModel(data, columnNames);
		jt = new JTable(model);
		// TableFitColumn.fitTableColumns(jt);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		jt.setEnabled(false);
		jt.setRowHeight(25);
		js.setViewportView(jt);
		jp.add(js);
		jp.setVisible(false);
		jp.setBounds(220, 50, 720, 465);
		jt.setPreferredScrollableViewportSize(new Dimension(700, 400));

		Search_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Search_Button) {
					new PartStudentSearch();
				}
			}
		});
		jp.add(Search_Button);
	}

	public JPanel getpanel() {
		return jp;
	}
}
