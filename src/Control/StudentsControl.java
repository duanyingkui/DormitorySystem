package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import JDBC.db;
import Model.StudentsModel;
import Operation.StudentsOperation;

public class StudentsControl {

	public void add(StudentsModel student) throws Exception {
		StudentsOperation addstudent = new StudentsOperation();
		addstudent.AddStudents(student);
	}

	public void update(StudentsModel student) throws Exception {
		StudentsOperation upstudent = new StudentsOperation();
		upstudent.UpdateStudents(student);

	}

	public List<StudentsModel> all() throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.selectall();

	}
	
	public List<StudentsModel> statusall() throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.statusselect();

	}

	public StudentsModel get(Integer student_id) throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.selectone(student_id);

	}
	
	

}
