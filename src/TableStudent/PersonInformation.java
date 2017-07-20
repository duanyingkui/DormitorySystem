package TableStudent;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Operation.StudentsOperation;
import System.Login;

public class PersonInformation {
	public static JPanel jpl = new JPanel();

	JLabel[] lab = new JLabel[13];
	String labstr[] = { "姓名         ", "性别         ", "出生日期", "地址         ", "联系方式", "学号         ", "学院         ",
			"专业         ", "班级         ", "宿舍楼号", "床号         ", "状态         " };

	public static JTextField[] text = new JTextField[12];
	JLabel lab1, lab2;

	public PersonInformation() {

		lab1 = new JLabel("个人信息");
		lab1.setFont(new Font("华文彩云", Font.BOLD, 23));
		jpl.add(lab1);

		/**
		 * 循环标签
		 */
		for (int i = 0; i < 12; i++) {
			lab[i] = new JLabel(labstr[i]);
			lab[i].setFont(new Font("华文行楷", Font.PLAIN, 18));
		}
		/**
		 * 循环文本框
		 */
		for (int i = 0; i < 12; i++) {
			text[i] = new JTextField(15);
			text[i].setFont(new Font("隶书", Font.PLAIN, 16));
			text[i].setEditable(false);

		}

		student(Login.text1.getText());

		Box boxVertical = new Box(BoxLayout.Y_AXIS); // 创建从上到下盒子布局
		Box titleBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		titleBox.add(lab1);
		titleBox.add(Box.createHorizontalStrut(36));
		boxVertical.add(titleBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box nameBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		nameBox.add(lab[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(text[0]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(lab[1]);
		nameBox.add(Box.createHorizontalStrut(36));
		nameBox.add(text[1]);
		boxVertical.add(nameBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box dateBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		dateBox.add(lab[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(text[2]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(lab[3]);
		dateBox.add(Box.createHorizontalStrut(36));
		dateBox.add(text[3]);
		boxVertical.add(dateBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box contactBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		contactBox.add(lab[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(text[4]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(lab[5]);
		contactBox.add(Box.createHorizontalStrut(36));
		contactBox.add(text[5]);
		boxVertical.add(contactBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box collegeBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		collegeBox.add(lab[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(text[6]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(lab[7]);
		collegeBox.add(Box.createHorizontalStrut(36));
		collegeBox.add(text[7]);
		boxVertical.add(collegeBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box classBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		classBox.add(lab[9]);
		classBox.add(Box.createHorizontalStrut(36));
		classBox.add(text[9]);
		classBox.add(Box.createHorizontalStrut(36));
		classBox.add(lab[8]);
		classBox.add(Box.createHorizontalStrut(36));
		classBox.add(text[8]);
		boxVertical.add(classBox);
		boxVertical.add(Box.createVerticalStrut(40));

		Box bedidBox = Box.createHorizontalBox();// 创建从左到右盒子布局
		bedidBox.add(lab[10]);
		bedidBox.add(Box.createHorizontalStrut(36));
		bedidBox.add(text[10]);
		bedidBox.add(Box.createHorizontalStrut(36));
		bedidBox.add(lab[11]);
		bedidBox.add(Box.createHorizontalStrut(36));
		bedidBox.add(text[11]);
		boxVertical.add(bedidBox);
		boxVertical.add(Box.createVerticalStrut(40));
		jpl.add(boxVertical);

		jpl.setVisible(false);
		jpl.setBounds(220, 50, 715, 465);

	}

	public Component getpanel() {
		return jpl;
	}

	public void student(String text1) {
		StudentsOperation studentone = new StudentsOperation();
		try {
			studentone.selectstudentone(text1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		text[0].setText(StudentsOperation.re.getName());
		text[1].setText(StudentsOperation.re.getSex());
		text[2].setText(StudentsOperation.re.getBirthday());
		text[3].setText(StudentsOperation.re.getAddress());
		text[4].setText(StudentsOperation.re.getContact());
		text[5].setText(Login.text1.getText());
		text[6].setText(StudentsOperation.re.getCollege());
		text[7].setText(StudentsOperation.re.getMajor());
		text[8].setText(StudentsOperation.re.getClasses());
		text[9].setText(StudentsOperation.re.getDorm_id());
		text[10].setText(StudentsOperation.re.getBed_id() + "");
		text[11].setText(StudentsOperation.re.getStatus() + "");
		return;

	}

}
