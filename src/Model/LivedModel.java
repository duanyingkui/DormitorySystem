package Model;

import java.util.Date;

import javax.xml.crypto.Data;

public class LivedModel {

	private Integer student_id;
	private String dorm_id;
	private Integer bed_num;
	private Date livingdate;

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getDorm_id() {
		return dorm_id;
	}

	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}

	public Integer getBed_num() {
		return bed_num;
	}

	public void setBed_num(Integer bed_num) {
		this.bed_num = bed_num;
	}

	public Date getLivingdate() {
		return livingdate;
	}

	public void setLivingdate(Date livingdate) {
		this.livingdate = livingdate;
	}

}
