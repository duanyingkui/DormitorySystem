package TableAdministrator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ButtonFrame.StudentAdd;
import ButtonFrame.StudentSearch;
import Control.StudentsControl;
import Model.StudentsModel;
import Operation.DormOperation;
import Operation.RegisterOperation;
import Operation.StudentsOperation;
import Operation.TableFitColumn;

public class StudentTable {
	public Object data[][] = null;

	Object columnNames[] = { "姓名", "性别", "出生日期", "地址", "联系方式", "学号", "学院", "专业", "班级", "宿舍号", "床号" };
	public static JPanel jp = new JPanel();
	public static JTable jt = new JTable();
	public static DefaultTableModel model;

	JButton Add_Button;
	JButton Update_Button;
	JButton Delete_Button;
	JButton Search_Button;

	public StudentTable() {
		Add_Button = new JButton("添加");
		Update_Button = new JButton("刷新");
		Delete_Button = new JButton("删除");
		Search_Button = new JButton("查询");

		JScrollPane js = new JScrollPane();
		jt = new JTable(model);
		jt = new JTable(querystudent());
		jt.setVisible(true);
		TableFitColumn.fitTableColumns(jt);// 自适应列宽
		// jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		jt.setRowHeight(25);
		jt.setEnabled(true);
		js.setViewportView(jt);
		jp.add(js);
		Add_Button.setVisible(true);
		Add_Button.addActionListener(AddButton);
		jp.add(Add_Button);

		Update_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setModel(querystudent());
				TableFitColumn.fitTableColumns(jt);// 自适应列宽
				
			}
		});
		jp.add(Update_Button);

		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Delete_Button) {

					String[] options = new String[] { "是", "否" };
					// 点击是的话
					int row = jt.getSelectedRow();
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "请选择要删除的行！", "提示：", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					int n = JOptionPane.showOptionDialog(null, "确认删除？？？", "提示", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if (n == JOptionPane.YES_OPTION) {
						if (row != -1) {
							StudentsOperation student = new StudentsOperation();
							DormOperation dorm = new DormOperation();
							RegisterOperation registerOperation = new RegisterOperation();
							try {
								student.UpdateStatusStudents((int) jt.getValueAt(jt.getSelectedRow(), 5));
								dorm.UpDateRemoveOneDorm(jt.getValueAt(jt.getSelectedRow(), 9));
								registerOperation.Delete((int) jt.getValueAt(jt.getSelectedRow(), 5));
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							model.removeRow(row);
						}

					}

				}
			}
		});
		jp.add(Delete_Button);

		Search_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Search_Button) {
					new StudentSearch();
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

	public Object getjtable() {
		return jt.getValueAt(jt.getSelectedRow(), 5);
	}

	public DefaultTableModel querystudent() {
		StudentsControl studentcontrol = new StudentsControl();
		List<StudentsModel> result;
		try {
			result = studentcontrol.all();
			data = new Object[result.size()][11];
			int j = 0;
			for (int i = 0; i < result.size(); i++) {
				data[i][j] = result.get(i).getName();
				j++;
				data[i][j] = result.get(i).getSex();
				j++;
				data[i][j] = StudentsOperation.getfromunix((String) result.get(i).getBirthday());
				;
				j++;
				data[i][j] = result.get(i).getAddress();
				j++;
				data[i][j] = result.get(i).getContact();
				j++;
				data[i][j] = result.get(i).getStudent_id();
				j++;
				data[i][j] = result.get(i).getCollege();
				j++;
				data[i][j] = result.get(i).getMajor();
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
		return model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	ActionListener AddButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new StudentAdd();

		}
	};

}
