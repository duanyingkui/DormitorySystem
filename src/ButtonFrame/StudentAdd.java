package ButtonFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import AddMessage.AddStudent;
import Control.StudentsControl;
import Model.StudentsModel;
import Operation.DormOperation;
import Operation.RegisterOperation;
import Operation.StudentsOperation;
import Operation.TableFitColumn;
import TableAdministrator.DormTable;
import TableAdministrator.StudentTable;

public class StudentAdd extends JFrame {
	JFrame Add_Frame;
	JButton Add_OkButton;
	Integer a = 0;
	JLabel[] lab = new JLabel[13];
	String[] labstr = { "姓名", "性别", "出生日期", "地址", "联系方式", "学号", "学院", "专业", "班级", "宿舍楼号", "床号", "状态" };

	JTextField[] text = new JTextField[13];

	ButtonGroup group = new ButtonGroup();

	JRadioButton Add_sexboy, Add_sexgirl;
	JPanel jp;

	JComboBox CollegeBox;
	String[] CollegeMajor = { "信息工程学院", "生命科学学院", "经济管理学院", "航天学院" };

	JComboBox MajorBox;
	String[] InformationMajor = { "计算机科学与技术", "物联网工程", "信息工程", "通信工程", "教育技术学" };

	String[] LifeMajor = { "生物科学", "生物技术", "生物工程" };

	String[] IncomeMajor = { "会计学", "经济学", "市场营销" };

	String[] SpaceFlight = { "飞行器制造工程", "机械设计及其自动化", "测控技术与仪器" };

	public static JComboBox DormitoryBox;
	String[] Dormitory = null;

	public static JComboBox Bed_idBox;
	String[] bed_id = { "1", "2", "3", "4" };

	public StudentAdd() {
		Image image = this.getToolkit().getImage("image\\icon.png");
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(300, 500);
		Add_Frame = new JFrame();
		Add_Frame.setIconImage(image);
		Add_Frame.setSize(260, 550);
		Add_Frame.setResizable(false);

		/**
		 * 循环标签
		 */
		for (int i = 0; i < 12; i++) {
			lab[i] = new JLabel(labstr[i]);

		}
		/**
		 * 循环文本框
		 */
		for (int i = 0; i < 12; i++) {
			text[i] = new JTextField(10);

		}

		/**
		 * 学院下拉列表框的项
		 */
		CollegeBox = new JComboBox();
		for (int i = 0; i < 4; i++) {
			CollegeBox.addItem(CollegeMajor[i]);
		}

		/**
		 * 床号下拉列表项
		 */
		Bed_idBox = new JComboBox();
		Bed_idBox.setEditable(true);

		for (int i = 0; i < 4; i++) {
			Bed_idBox.addItem(bed_id[i]);
		}

		/**
		 * 宿舍下拉列表内容
		 */
		DormitoryBox = new JComboBox();
		try {
			for (int i = 0; i < DormOperation.selectdorm_id().size(); i++) {
				try {
					DormitoryBox.addItem(DormOperation.selectdorm_id().get(i).getDorm_id());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DormitoryBox.setEditable(true);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Add_Frame.setVisible(true);
		Add_Frame.setLocationRelativeTo(null);

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box nameBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		nameBox.add(lab[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(text[0]);
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box sexBox = Box.createHorizontalBox();
		sexBox.add(lab[1]);
		JPanel sexPanel = new JPanel();
		sexPanel.setLayout(new FlowLayout(FlowLayout.LEFT));// 流布局按钮呈水平拜访
		sexBox.add(Box.createHorizontalStrut(30));
		Add_sexboy = new JRadioButton();
		Add_sexboy.setText("男");
		Add_sexgirl = new JRadioButton("女");
		Add_sexboy.setSelected(true);
		group.add(Add_sexboy);
		group.add(Add_sexgirl);
		sexPanel.add(Add_sexboy);
		sexPanel.add(Add_sexgirl);
		sexBox.add(sexPanel);
		boxVertical.add(sexBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box birthdayBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		birthdayBox.add(lab[2]);
		birthdayBox.add(Box.createHorizontalStrut(10));
		birthdayBox.add(text[2]);
		boxVertical.add(birthdayBox);
		boxVertical.add(Box.createVerticalStrut(15));

		text[2].setText("例:19960101");
		text[2].setForeground(Color.RED);
		text[2].addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				text[2].setForeground(Color.BLACK);
				text[2].setText("");
			}
		});

		Box addresssBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		addresssBox.add(lab[3]);
		addresssBox.add(Box.createHorizontalStrut(36));
		addresssBox.add(text[3]);
		boxVertical.add(addresssBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box contactBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		contactBox.add(lab[4]);
		contactBox.add(Box.createHorizontalStrut(10));
		contactBox.add(text[4]);
		boxVertical.add(contactBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box student_idBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		student_idBox.add(lab[5]);
		student_idBox.add(Box.createHorizontalStrut(36));
		student_idBox.add(text[5]);
		boxVertical.add(student_idBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box collegeBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		collegeBox.add(lab[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(CollegeBox);
		boxVertical.add(collegeBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box majorBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		majorBox.add(lab[7]);
		majorBox.add(Box.createHorizontalStrut(36));
		MajorBox = new JComboBox(InformationMajor);
		majorBox.add(MajorBox);
		CollegeBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (CollegeBox.getSelectedItem().equals("生命科学学院")) {
					MajorBox.removeAllItems();
					for (int i = 0; i < 3; i++) {
						MajorBox.addItem(LifeMajor[i]);
					}
				} else if (CollegeBox.getSelectedItem().equals("经济管理学院")) {
					MajorBox.removeAllItems();
					for (int i = 0; i < 3; i++) {
						MajorBox.addItem(IncomeMajor[i]);
					}

				} else {
					MajorBox.removeAllItems();
					for (int i = 0; i < 3; i++) {
						MajorBox.addItem(SpaceFlight[i]);
					}

				}

			}
		});
		boxVertical.add(majorBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box classesBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		classesBox.add(lab[8]);
		classesBox.add(Box.createHorizontalStrut(36));
		classesBox.add(text[8]);
		boxVertical.add(classesBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box dorm_idBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		dorm_idBox.add(lab[9]);
		dorm_idBox.add(Box.createHorizontalStrut(10));
		dorm_idBox.add(DormitoryBox);
		boxVertical.add(dorm_idBox);
		boxVertical.add(Box.createVerticalStrut(15));
		/**
		 * 宿舍下拉列表的监听,显示可以选择的床号
		 */
		DormitoryBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Bed_idBox.removeAllItems();
					Bed_idBox.addItem(bed_id[0]);
					Bed_idBox.addItem(bed_id[1]);
					Bed_idBox.addItem(bed_id[2]);
					Bed_idBox.addItem(bed_id[3]);
					for (int i = 0; i < StudentsOperation.selectdorm(DormitoryBox.getSelectedItem().toString())
							.size(); i++) {

//						System.out.println(
//								StudentsOperation.selectdorm(DormitoryBox.getSelectedItem().toString()).size() + "大小");
//						System.out.println(StudentsOperation.selectdorm(DormitoryBox.getSelectedItem().toString())
//								.get(i).getBed_id() + "学生表床号");
//						System.out.println(bed_id[i] + "床号");
//						System.out.println(bed_id[i].equals(StudentsOperation
//								.selectdorm(DormitoryBox.getSelectedItem().toString()).get(i).getBed_id()));
						if (bed_id[i].equals(StudentsOperation.selectdorm(DormitoryBox.getSelectedItem().toString())
								.get(i).getBed_id())) {
						} else {
							Bed_idBox.removeItem(bed_id[i]);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Box bed_idBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		bed_idBox.add(lab[10]);
		bed_idBox.add(Box.createHorizontalStrut(36));
		bed_idBox.add(Bed_idBox);
		boxVertical.add(bed_idBox);
		boxVertical.add(Box.createVerticalStrut(15));

		Box statusBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		statusBox.add(lab[11]);
		statusBox.add(Box.createHorizontalStrut(36));
		statusBox.add(text[11]);
		boxVertical.add(statusBox);
		boxVertical.add(Box.createVerticalStrut(15));
		lab[11].setVisible(false);
		text[11].setText("0");
		text[11].setEditable(false);
		text[11].setVisible(false);

		Box addokBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		Add_OkButton = new JButton("确认");
		Add_OkButton.setVisible(true);
		Add_OkButton.addActionListener(AddOKButton);

		addokBox.add(Add_OkButton);
		addokBox.add(Box.createHorizontalStrut(0));
		boxVertical.add(addokBox);
		boxVertical.add(Box.createVerticalStrut(15));
		Add_Frame.setLayout(new FlowLayout());
		Add_Frame.add(boxVertical);

	}

	/**
	 * 添加学生的确认按钮
	 */

	ActionListener AddOKButton = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//System.out.println(DormitoryBox.getSelectedItem().toString() + "宿舍楼号");
				if (new AddStudent().AddStudent(text, Add_sexboy, Add_sexgirl, CollegeBox, DormitoryBox,
						MajorBox) == false) {
					return;
				}
				boolean b = true;
				for (int i = 0; i < DormOperation.selectdorm_id().size(); i++) {
					// System.out.println(DormitoryBox.getSelectedItem().toString()
					// .equals(DormOperation.selectdorm_id().get(i).getDorm_id()));
					// System.out.println(DormOperation.selectdorm_id().get(i).getDorm_id());
					if (DormitoryBox.getSelectedItem().equals(DormOperation.selectdorm_id().get(i).getDorm_id())) {
						new DormOperation().UpDateoneDorm(DormitoryBox.getSelectedItem().toString());
						new RegisterOperation().AddStudentRegister(text[5].getText());
						
						// System.out.println("执行了");
						b = false;
						break;
					}
				}
				if (b) {
					new DormOperation().AddStudentDorm(DormitoryBox.getSelectedItem().toString(), "4", a);
					}
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			StudentTable.jt.setModel(querystudent());
			TableFitColumn.fitTableColumns(StudentTable.jt);// 自适应列宽
		}
	};
	Object columnNames[] = { "姓名", "性别", "出生日期", "地址", "联系方式", "学号", "学院", "专业", "班级", "宿舍号", "床号" };
	public Object data[][] = null;
	public static DefaultTableModel model;
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

}
