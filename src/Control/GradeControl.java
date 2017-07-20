package Control;

import java.util.List;

import Model.GradeModel;
import Operation.GradeOperation;

public class GradeControl {
	public void add(GradeModel Grademodel) throws Exception {
		GradeOperation addgrade = new GradeOperation();
		addgrade.AddGrade(Grademodel);
	}

	public void update(GradeModel grademodel) throws Exception {
		GradeOperation updatelive = new GradeOperation();
		updatelive.DeleteLived(grademodel);
	}

	public void delete(GradeModel grademodel) throws Exception {
		GradeOperation deletelive = new GradeOperation();
		deletelive.DeleteLived(grademodel);
	}

	public List<GradeModel> query() throws Exception {
		GradeOperation selope = new GradeOperation();
		return selope.selectall();

	}

	public GradeModel get(Integer student_id) throws Exception {
		GradeOperation selone = new GradeOperation();
		return selone.selectone(student_id);
	}

}
