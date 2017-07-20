package Control;

import java.util.List;

import Model.LivedModel;
import Operation.LivedOperation;

public class LivedControl {

	public void add(LivedModel livemodel) throws Exception {
		LivedOperation addlived = new LivedOperation();
		addlived.AddLived(livemodel);
	}

	public void update(LivedModel livemodel) throws Exception {
		LivedOperation updatelive = new LivedOperation();
		updatelive.UpDateLived(livemodel);
	}

	public void delete(LivedModel livemodel) throws Exception {
		LivedOperation deletelive = new LivedOperation();
		deletelive.DeleteLived(livemodel);
	}

	public List<LivedModel> query() throws Exception {
		LivedOperation selope = new LivedOperation();
		return selope.selectall();

	}

	public LivedModel get(Integer student_id) throws Exception {
		LivedOperation selone = new LivedOperation();
		return selone.selectone(student_id);
	}
}
