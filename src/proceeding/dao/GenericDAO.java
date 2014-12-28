package proceeding.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDAO<T> {
	//Protected 
	protected final String tableName;
	protected Connection   conn;
	
	protected GenericDAO(Connection conn, String tableName) {
		this.tableName = tableName;
		this.conn      = conn;
	}
	public abstract int count() throws SQLException; 
	 
}
