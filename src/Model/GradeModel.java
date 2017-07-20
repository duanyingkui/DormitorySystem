package Model;

import java.util.Date;

public class GradeModel {

	private Integer grade_id;
	private String dorm_id;
	private Integer discipline;
	private Integer checks;
	private Integer health;
	private Integer grade;
	private Date dates;
	private Integer managers_id;

	public Integer getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}

	public String getDorm_id() {
		return dorm_id;
	}

	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}

	public Integer getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
	}

	public Integer getChecks() {
		return checks;
	}

	public void setChecks(Integer checks) {
		this.checks = checks;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public Integer getManagers_id() {
		return managers_id;
	}

	public void setManagers_id(Integer managers_id) {
		this.managers_id = managers_id;
	}
}
