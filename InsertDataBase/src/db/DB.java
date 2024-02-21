package db;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.StatementEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	public static Connection conn = null; 
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = null;
			props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {conn.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void closeStatiment(Statement st) {
		if(st != null) {
			try {
			st.close();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	}
		public static void closeResultStatement(ResultSet rs) {
			if(rs != null) {
				try {
				rs.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
