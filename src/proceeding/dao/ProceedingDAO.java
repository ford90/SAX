package proceeding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proceeding.model.Proceeding;

public class ProceedingDAO extends GenericDAO<Proceeding> {
	private static String TABLENAME = "Proceeding";
	
	public ProceedingDAO(Connection conn) {
		super(conn, TABLENAME);
	}
	
	public void update(Proceeding proc) {
		try {
			String query = "INSERT INTO PROCEEDING (" +
						"TEMP_OBJ_ID, FINAL_OBJ_ID, ACRONYM, CONF_END_DT )" +
						" VALUES ( 'test', 'ford', '" + proc.getAcronym() + "', '" +
						proc.getConfEndDt() + "')";
			System.out.println(query);
			Statement stmt = this.conn.createStatement();
			stmt.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int count() throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM "+this.tableName;
        PreparedStatement counter;
        try
        {
        counter = this.conn.prepareStatement(query);
        ResultSet res = counter.executeQuery();
        res.next();
        return res.getInt("count");
        }
        catch(SQLException e){ throw e; }
	}
}