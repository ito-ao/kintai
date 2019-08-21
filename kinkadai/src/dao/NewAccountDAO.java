package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mod.Login;
import mod.User;

public class NewAccountDAO {
	public User saveToDatabase(Login login) throws ClassNotFoundException  {

	Connection conn = null;
	User user = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/kintai", "root", "1234");

		String sql = "INSERT INTO KOJIN(name,pass)VALUES(?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.setString(1, login.getName());
		pStmt.setString(2, login.getPass());

		if(pStmt.executeUpdate() != 0) {
			System.out.println("データベースに保存かんりょおおおお");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return user;

	}
}
