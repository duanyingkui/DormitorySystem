package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import JDBC.db;
import Model.ManagersModel;
import Model.StudentsModel;

public class ManagerOperation {
/**
 * 对应方法
 * @param m
 * @throws Exception
 */
	public static ManagersModel managers = null;

	JTextField  text1,text2,text3;
	String manager_id;
	public void AddManager(ManagersModel m) throws Exception {
		// 获得数据库连接
		Connection conn = db.getConnection();
		// 预编译（将SQL语句加载到指定程序中并不直接执行直到调用execute才执行用？（占位符）表示）
		PreparedStatement prepare = conn.prepareStatement(" insert into managers " + " values(?,?,?) ");
		// 传参
		prepare.setString(1, m.getManager_name());
		prepare.setInt(2, m.getManager_id());
		prepare.setString(3, m.getContact());
		prepare.execute();

	}

	public void UpdateManager(ManagersModel m) throws SQLException {
		// 获得数据库连接
		Connection conn = db.getConnection();
		// 预编译（将SQL语句加载到指定程序中并不直接执行直到调用execute才执行用？（占位符）表示）
		PreparedStatement prepare = conn.prepareStatement(" update managers set contact=? where manager_id=? ");
		// 传参
		prepare.setString(1, m.getContact());
		prepare.setInt(2, m.getManager_id());
		prepare.execute();
	}
	//更改宿管信息
	public void UpdateOneManager(String manager_id,JTextField text1, JTextField text2, JTextField text3) throws SQLException {
		this.manager_id=manager_id;
		this.text1=text1;
		this.text2=text2;
		this.text3=text3;
		Connection conn = db.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update managers set manager_name = ? , contact = ?    where manager_id = ? ");
		prepareupdate.setString(1, text1.getText());
		prepareupdate.setString(2, text3.getText());
		prepareupdate.setString(3,text2.getText() );
		prepareupdate.execute();
	}

	public void DeleteManager(Integer manager_id) throws SQLException {
		// 获得数据库连接
		Connection conn = db.getConnection();
		// 预编译（将SQL语句加载到指定程序中并不直接执行直到调用execute才执行用？（占位符）表示）
		PreparedStatement prepare = conn.prepareStatement(" delete from managers where manager_id = ? ");
		// 传参
		prepare.setInt(1, manager_id);
		prepare.execute();
	}
	public void DeleteRemove(Object row) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from managers where manager_id = ? ");
		delete.setInt(1, (int) row);
		delete.execute();
	}

	public List<ManagersModel> query() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from managers ");
		List<ManagersModel> manag = new ArrayList<ManagersModel>();
		ManagersModel m = null;
		while (rs.next()) {
			m = new ManagersModel();
			m.setManager_name(rs.getString("manager_name"));
			m.setManager_id(rs.getInt("manager_id"));
			m.setContact(rs.getString("contact"));
			manag.add(m);
		}
		return manag;
	}
	/**
	 * 管理员联系方式
	 * @return
	 * @throws Exception
	 */
	public static List<ManagersModel> contact() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from managers ");
		List<ManagersModel> manag = new ArrayList<ManagersModel>();
		ManagersModel m = null;
		while (rs.next()) {
			m = new ManagersModel();		
			m.setContact(rs.getString("contact"));
			manag.add(m);
		}
		return manag;
	}

	
	/**
	 * 管理员员工号
	 * @return
	 * @throws Exception
	 */
	public static List<ManagersModel> manager_id() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from managers ");
		List<ManagersModel> manag = new ArrayList<ManagersModel>();
		ManagersModel m = null;
		while (rs.next()) {
			m = new ManagersModel();		
			m.setManager_id(Integer.parseInt(rs.getString("manager_id")));
			manag.add(m);
		}
		return manag;
	}
	/*
	 * statement执行不带参数的简单SQL语句（发送SQL语句） PreparedStatement接口继承了Statement
	 */
	public static ManagersModel get(Integer manager_id) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement psm = conn.prepareStatement(" select * from managers where manager_id = ? ");
		psm.setInt(1, manager_id);
		// 返回结果集
		ResultSet rs = psm.executeQuery();
		while (rs.next()) {
			managers = new ManagersModel();
			managers.setManager_name(rs.getString("manager_name"));
			managers.setManager_id(rs.getInt("Manager_id"));
			managers.setContact(rs.getString("contact"));
		}
		return managers;

	}
	public ManagersModel mode(){
		return managers;
		
	}

}
