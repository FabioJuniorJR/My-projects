/*
 * Acessando banco de dados e imprimindo valores da tabela departamento
 * */
package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class program {

	public static void main(String[] args) {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				conn = DB.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery("select * from department");
				while(rs.next()) {
					System.out.println(rs.getInt("id") + ", " + rs.getString("Name"));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DB.closeStatiment(st);
			DB.closeResultStatement(rs);
			DB.closeConnection();
		}


			

	}

}
