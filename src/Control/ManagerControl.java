package Control;

import java.util.List;

import Model.ManagersModel;
import Operation.ManagerOperation;

public class ManagerControl {

	public void add(ManagersModel managermodel) throws Exception {
		ManagerOperation addope = new ManagerOperation();
		addope.AddManager(managermodel);
	}

	public void update(ManagersModel managermodel) throws Exception {
		ManagerOperation updateope = new ManagerOperation();
		updateope.UpdateManager(managermodel);
	}

	public void delete(Integer manager_id) throws Exception {
		ManagerOperation delope = new ManagerOperation();
		delope.DeleteManager(manager_id);
	}

	public List<ManagersModel> query() throws Exception {
		ManagerOperation selope = new ManagerOperation();
		return selope.query();

	}

	public ManagersModel get(Integer manager_id) throws Exception {
		ManagerOperation selone = new ManagerOperation();
		return selone.get(manager_id);
	}
}
