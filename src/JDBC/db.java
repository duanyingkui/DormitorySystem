package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	private static final String url = "jdbc:mysql://localhost:3306/domitory";
	private static final String user = "root";
	private static final String password = "666666";

	public static Connection conn = null;

	static {

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 得到数据库连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
