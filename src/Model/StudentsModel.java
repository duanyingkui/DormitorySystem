package Model;

public class StudentsModel {

	private String name,sex,birthday,address,contact,college, major,classes,dorm_id,status;
	private Integer bed_id,student_id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getBirthday() {		
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday =birthday;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String clooege) {
		this.college = clooege;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDorm_id() {
		return dorm_id;
	}
	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}
	public Integer getBed_id() {
		return bed_id;
	}
	public void setBed_id(Integer bed_id) {
		this.bed_id = bed_id;
		System.out.println();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
