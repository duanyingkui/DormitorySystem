package AddMessage;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Control.GradeControl;
import Model.GradeModel;

public class AddGrade {
	JTextField[] text;
	JComboBox dorm;

	public AddGrade(JTextField[] text, JComboBox dorm) throws Exception {
		this.text = text;
		GradeControl gradetcontrol = new GradeControl();
		GradeModel grademodel = new GradeModel();
		grademodel.setDorm_id(dorm.getSelectedItem().toString());
		if (text[1].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{1}");
			Matcher NameMatcher = NamePattren.matcher(text[1].getText());
			if (NameMatcher.matches()) {
				grademodel.setDiscipline(Integer.parseInt(text[1].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "纪律分请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[1].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "纪律分不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (text[2].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{1}");
			Matcher NameMatcher = NamePattren.matcher(text[2].getText());
			if (NameMatcher.matches()) {
				grademodel.setChecks(Integer.parseInt(text[2].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "考勤分请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[2].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "考勤分不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (text[3].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{1}");
			Matcher NameMatcher = NamePattren.matcher(text[3].getText());
			if (NameMatcher.matches()) {
				grademodel.setHealth(Integer.parseInt(text[3].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "卫生分请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[3].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "卫生分不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (text[4].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{1,2}");
			Matcher NameMatcher = NamePattren.matcher(text[4].getText());
			if (NameMatcher.matches()) {
				grademodel.setGrade(Integer.parseInt(text[4].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "总分请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[4].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "总分不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (text[5].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
			Matcher NameMatcher = NamePattren.matcher(text[5].getText());
			if (NameMatcher.matches()) {
				grademodel.setDates(Date.valueOf(text[5].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "评分时间请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[5].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "评分时间不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (text[6].getText().length() != 0) {
			Pattern NamePattren = Pattern.compile("\\d{6}");
			Matcher NameMatcher = NamePattren.matcher(text[6].getText());
			if (NameMatcher.matches()) {
				grademodel.setManagers_id(Integer.parseInt(text[6].getText()));
			} else {
				JOptionPane.showMessageDialog(null, "评分人请输入正确格式", "系统提示", JOptionPane.ERROR_MESSAGE);
				text[6].setText("");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "评分人不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		gradetcontrol.add(grademodel);
	}
}
