package proceeding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import proceeding.dao.GenericDAO;
import proceeding.dao.ProceedingDAO;

public class DAOManager {

	private DataSource src;
	private Connection conn;
	
	public enum Table { PROCEEDING };
	
	public DAOManager() {	
		String user     = "sax";
		String password = "sax";
		String url      = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				this.conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() throws SQLException {
		if(this.conn != null || this.conn.isClosed()) {
			this.conn.close();
		}
	}
	
	public GenericDAO getDAO(Table t) throws SQLException{
		switch(t) {
			case PROCEEDING:
				return new ProceedingDAO(this.conn);
			default:
				throw new SQLException("Table does not exist");
		}
	}
}
