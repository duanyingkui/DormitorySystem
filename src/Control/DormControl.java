package Control;

import java.util.List;

import Model.DormModel;
import Model.GradeModel;
import Operation.DormOperation;
import Operation.GradeOperation;

public class DormControl {

	public void add(DormModel dormmodel) throws Exception {
		DormOperation addgrade = new DormOperation();
		addgrade.AddDorm(dormmodel);
	}

	public void update(DormModel dormmodel) throws Exception {
		DormOperation updatedorm = new DormOperation();
		updatedorm.UpDateDorm(dormmodel);
	}

	public void delete(DormModel dormmodel) throws Exception {
		DormOperation deletedorm = new DormOperation();
		deletedorm.DeleteDorm(dormmodel);
	}

	public List<DormModel> query() throws Exception {
		DormOperation selope = new DormOperation();
		return selope.selectall();

	}

	public DormModel get(String dorm_id) throws Exception {
		DormOperation selone = new DormOperation();
		return selone.selectone(dorm_id);
	}

}
