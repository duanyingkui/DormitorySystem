package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC.db;
import Model.DormModel;

public class DormOperation {
	public static DormModel live = null;
	String dorm;
	String bed_id;

	public void AddDorm(DormModel adddorm) throws Exception {
		// 获得数据库连接
		Connection conn = db.getConnection();
		// 预编译（将SQL语句加载到指定程序中并不直接执行直到调用execute才执行用？（占位符）表示）
		PreparedStatement prepare = conn.prepareStatement(" insert into dorm " + " values(?,?,?) ");
		// 传参
		prepare.setString(1, adddorm.getDorm_id());
		prepare.setInt(2, adddorm.getBed_num());
		prepare.setInt(3, adddorm.getPeople_num());
		prepare.execute();
	}

	/**
	 * 添加学生宿舍信息
	 * 
	 * @param dorm
	 *            宿舍号
	 * @param bed_num
	 *            床号
	 * @param people_num
	 *            人数
	 * @throws Exception
	 */

	public void AddStudentDorm(String dorm, String bed_num, Integer people_num) throws Exception {

		// 获得数据库连接
		Connection conn = db.getConnection();
		// 预编译（将SQL语句加载到指定程序中并不直接执行直到调用execute才执行用？（占位符）表示）
		PreparedStatement prepare = conn
				.prepareStatement(" insert into  dorm (dorm_id,bed_num,people_num) " + " values(?,?,?) ");
		// 传参
		prepare.setString(1, dorm);
		prepare.setString(2, bed_num);
		prepare.setInt(3, people_num + 1);
		prepare.execute();
	}

	/**
	 * 更新宿舍信息
	 * 
	 * @param updatedorm
	 * @throws SQLException
	 */
	public void UpDateDorm(DormModel updatedorm) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement(" update dorm set dorm_id = ? , bed_num=? , people_num = ? where dorm_id = ? ");
		prepare.setString(1, updatedorm.getDorm_id());
		prepare.setInt(2, updatedorm.getBed_num());
		prepare.setInt(3, updatedorm.getPeople_num());
		prepare.execute();
	}

	/**
	 * 更新宿舍人数
	 * 
	 * @param dorm_id
	 *            宿舍号
	 * @throws SQLException
	 */
	public void UpDateoneDorm(String dorm_id) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement(" update dorm set  people_num = people_num + 1   where dorm_id = ? ");
		prepare.setString(1, dorm_id);
		prepare.execute();
	}

	public void UpDateRemoveOneDorm(Object dorm_id) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement(" update dorm set  people_num = people_num - 1   where dorm_id = ? ");
		prepare.setString(1, (String) dorm_id);
		prepare.execute();
	}

	/**
	 * 删除宿舍信息
	 * 
	 * @param deletegrade
	 * @throws SQLException
	 */
	public void DeleteDorm(DormModel deletegrade) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn.prepareStatement("delete from dorm where dorm_id = ? ");
		prepare.setString(1, deletegrade.getDorm_id());
		prepare.execute();
	}

	/**
	 * 删除宿舍信息
	 * 
	 * @param row
	 *            当前选中行中的某一列
	 * @throws SQLException
	 */
	public void DeleteRemove(Object row) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from dorm where dorm_id = ? ");
		delete.setInt(1, (int) row);
		delete.execute();
	}

	/**
	 * 查询宿舍所有信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DormModel> selectall() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from dorm ");
		List<DormModel> live = new ArrayList<DormModel>();
		DormModel select = null;
		while (rs.next()) {
			select = new DormModel();
			select.setDorm_id(rs.getString("dorm_id"));
			select.setBed_num(rs.getInt("bed_num"));
			select.setPeople_num(rs.getInt("people_num"));
			live.add(select);
		}
		return live;

	}

	/**
	 * 查询所有宿舍号
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<DormModel> selectdorm_id() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select dorm_id from dorm where people_num<>4 ");
		List live = new ArrayList<DormModel>();
		DormModel select = null;
		while (rs.next()) {
			select = new DormModel();
			select.setDorm_id(rs.getString("dorm_id"));
			live.add(select);
		}
		return live;

	}

	/**
	 * 查询单条宿舍信息
	 * 
	 * @param dorm_id
	 * @return
	 * @throws Exception
	 */
	public static DormModel selectone(String dorm_id) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement select = conn.prepareStatement(" select * from dorm where dorm_id =  ? ");
		select.setString(1, dorm_id);
		// 返回结果集
		ResultSet rs = select.executeQuery();

		while (rs.next()) {
			live = new DormModel();
			live.setDorm_id(rs.getString("dorm_id"));
			live.setBed_num(rs.getInt("bed_num"));
			live.setPeople_num(rs.getInt("people_num"));
		}
		return live;
	}
}
