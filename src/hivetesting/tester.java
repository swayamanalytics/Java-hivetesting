package hivetesting;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class tester {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	/**
	* @param args
	* @throws SQLException
	**/
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive2://192.168.56.101:10786/default", "hadoop", "welcome");
		// show tables
		Statement stmt = con.createStatement();
		String sql = "select CURRENT_DATE";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString("_c0"));
		}
		
		
}}
