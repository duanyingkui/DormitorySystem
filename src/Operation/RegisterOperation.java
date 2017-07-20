package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JDBC.db;

import Model.RegisterModel;

public class RegisterOperation {
	JTextField text1;
	JPasswordField text2;
	public static RegisterModel re = null;
	public void Addregisterstudent(RegisterModel selectall) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn.prepareStatement(" insert into register " + " values(?,?,?) ");
		prepare.setInt(1, selectall.getIdentity());
		prepare.setInt(2, selectall.getAccountt());
		prepare.setString(3, selectall.getPassword());
		prepare.execute();
	}
	//学生账号添加
	public void AddStudentRegister(String account) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn.prepareStatement(" insert into register (identity,account)" + " values(?,?) ");
		prepare.setString(1, "学生");
		prepare.setString(2, account);	
		prepare.execute();
	}
	//宿管账号添加
	public void AddManagerRegister(String account) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn.prepareStatement(" insert into register (identity,account)" + " values(?,?) ");
		prepare.setString(1, "宿管");
		prepare.setString(2, account);	
		prepare.execute();
	}

	public void Update(JPasswordField text2,JTextField text1) throws SQLException {
		this.text1= text1;
		this.text2 = text2;
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn.prepareStatement(" update register set password = ? where account = ?  ");
		prepare.setString(1,text2.getText() );
		prepare.setInt(2, Integer.parseInt(text1.getText()));
		prepare.execute();// execute执行
	}
	

	public void Delete(Integer account) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from register where account = '"+account+"' ");
		//delete.setInt(1, account);
		delete.execute();
	}
	
	public void Deletemanager(Integer account) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from register where account = '"+account+"' ");
		//delete.setInt(1, account);
		delete.execute();
	}

	public void DeleteRe(Object row) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from register where account = ? ");
		delete.setInt(1, (int) row);
		delete.execute();
	}
	
	public List<RegisterModel> selectall() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from register ");
		List<RegisterModel> manag = new ArrayList<RegisterModel>();
		RegisterModel select = null;
		while (rs.next()) {
			select = new RegisterModel();
			select.setIdentity(rs.getInt("identity"));
			select.setAccountt(rs.getInt("account"));
			select.setPassword(rs.getString("password"));
			manag.add(select);
		}
		return manag;

	}

	public static RegisterModel selectone(Integer account) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement select = conn.prepareStatement(" select * from register where account =  ? ");
		select.setInt(1, account);
		// 返回结果集
		ResultSet rs = select.executeQuery();
		while (rs.next()) {
			re = new RegisterModel();
			re.setIdentity(rs.getInt("identity"));
			re.setAccountt(rs.getInt("account"));
			re.setPassword(rs.getString("password"));
		}
		return re;
	}

	public void Update(RegisterModel regis) {
		
	}
}
