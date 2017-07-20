package AddMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ButtonFrame.StudentAdd;
import Control.StudentsControl;
import Model.StudentsModel;
import Operation.StudentsOperation;
import TableAdministrator.StudentTable;

public class AddStudent {
	JTextField[] text;
	JRadioButton boy, girl;
	JComboBox CollegeBox, DormitoryBox, majorbox;

	public boolean AddStudent(JTextField[] text, JRadioButton boy, JRadioButton girl, JComboBox collegeBox,
			JComboBox dormitoryBox, JComboBox MajorBox) throws Exception {
		this.text = text;
		this.boy = boy;
		this.girl = girl;
		this.CollegeBox = collegeBox;
		this.DormitoryBox = dormitoryBox;
		this.majorbox = MajorBox;

		StudentsControl studentcontrol = new StudentsControl();
		StudentsModel studentmodel = new StudentsModel();

		if (text[0].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("([\u4e00-\u9fa5]{2,4})");
			Matcher NameMatcher = NamePattren.matcher(text[0].getText());
			if (NameMatcher.matches()) {
				studentmodel.setName(text[0].getText());
			} else {
				JOptionPane.showMessageDialog(null, "请输入正确名字格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[0].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "姓名不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (boy.isSelected()) {
			studentmodel.setSex(boy.getText());
		} else {
			studentmodel.setSex(girl.getText());
		}
		if (text[2].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{8}");
			Matcher NameMatcher = NamePattren.matcher(text[2].getText());
			if (NameMatcher.matches()) {
				studentmodel.setBirthday(text[2].getText());
			} else {
				JOptionPane.showMessageDialog(null, "请输入正确日期格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[2].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "日期不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (text[3].getText().length() != 0) {
			Pattern AddressPattern = Pattern.compile("([\u4e00-\u9fa5]){2,10}");
			Matcher AddressMatcher = AddressPattern.matcher(text[3].getText());
			if (AddressMatcher.matches()) {
				studentmodel.setAddress(text[3].getText());
			} else {
				JOptionPane.showMessageDialog(null, "请输入正确地址格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[3].setText("");
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "地址不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		

		if (text[4].getText().length() != 0) {
			Pattern ContactPattern = Pattern.compile("(^[1]([3578][0-9]{1})[0-9]{8}$)");
			Matcher ContactMatcher = ContactPattern.matcher(text[4].getText());
			if (ContactMatcher.matches()) {
				studentmodel.setContact(text[4].getText());

			} else {
				JOptionPane.showMessageDialog(null, "联系方式格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[4].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "联系方式不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		for (int i = 0; i < StudentsOperation.contactselect().size(); i++) {
			//System.out.println(StudentsOperation.contactselect().get(i).getContact() + "联系练习");
			if (text[4].getText().equals(StudentsOperation.contactselect().get(i).getContact())) {
				JOptionPane.showMessageDialog(null, "联系方式已存在", "系统提示", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		

		if (text[5].getText().length() != 0) {
			Pattern ContactPattern = Pattern.compile("([\\d]{9})");
			Matcher ContactMatcher = ContactPattern.matcher(text[5].getText());
			if (ContactMatcher.matches()) {
				studentmodel.setStudent_id(Integer.parseInt(text[5].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "学号格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[5].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "学号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		for (int i = 0; i < StudentsOperation.studentidselect().size(); i++) {
			// System.out.println(StudentsOperation.studentidselect().size()+"daxiao");
			//System.out.println(StudentsOperation.studentidselect().get(i).getStudent_id() + "学号存在数据库");
			//System.out.println(text[5].getText() + "文本框得到的学号");
			//System.out.println(text[5].getText().equals(StudentsOperation.studentidselect().get(i).getStudent_id()));
			if (StudentsOperation.studentidselect().get(i).getStudent_id()
					.equals(Integer.parseInt(text[5].getText()))) {
				JOptionPane.showMessageDialog(null, "学号已存在", "系统提示", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {

			}

		}
		studentmodel.setCollege(CollegeBox.getSelectedItem().toString());
		studentmodel.setMajor(MajorBox.getSelectedItem().toString());

		if (text[8].getText().length() != 0) {
			Pattern ContactPattern = Pattern.compile("[\u4e00-\u9fa5\\d]+$");
			Matcher ContactMatcher = ContactPattern.matcher(text[8].getText());
			if (ContactMatcher.matches()) {
				studentmodel.setClasses(text[8].getText());
			} else {
				JOptionPane.showMessageDialog(null, "班级格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[8].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "班级不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		studentmodel.setDorm_id(DormitoryBox.getSelectedItem().toString());
		// System.out.println(DormitoryBox.getSelectedItem().toString()+"sushelouhao");
		// System.out.println(StudentsOperation.selectdorm(DormitoryBox.getSelectedItem().toString())+"打打打打打");

	
		studentmodel.setBed_id(Integer.parseInt(StudentAdd.Bed_idBox.getSelectedItem().toString()));
		
		if (text[11].getText().length() != 0) {
			Pattern ContactPattern = Pattern.compile("([\\d]{1})");
			Matcher ContactMatcher = ContactPattern.matcher(text[11].getText());
			if (ContactMatcher.matches()) {
				studentmodel.setStatus(text[11].getText());
			} else {
				JOptionPane.showMessageDialog(null, "状态格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[11].setText("");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "状态不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		studentcontrol.add(studentmodel);
		return true;
	}

}
