package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest {

	public static void main(String[] args) throws SQLException {
		String userName = "sax";
		String password = "sax";
		String driver   = "jdbc:oracle:thin:@localhost:1521:XE";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection(driver, userName, password);
		Statement stmt  = conn.createStatement();
		ResultSet result = stmt.executeQuery("Select * from proceeding");
		
		String str = "";
		while(result.next()) {
			str = result.getString(1);
			System.out.println(str);
		}
		System.out.println("Connection made");
	}

}
