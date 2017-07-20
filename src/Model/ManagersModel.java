package Model;

public class ManagersModel {
	private String manager_name;
	private Integer manager_id;
	private String contact;

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "ManagersModel [manager_name=" + manager_name + ", manager_id=" + manager_id + ", contact=" + contact
				+ "]";
	}

}
