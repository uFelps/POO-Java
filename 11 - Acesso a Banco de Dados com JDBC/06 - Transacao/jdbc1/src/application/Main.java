package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.Database;

public class Main {

	public static void main(String[] args) {

		Connection conn = null;
		Statement ps = null;
		
		try {
			conn = Database.getConnection();
			ps = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = ps.executeUpdate("UPDATE seller SET BaseSalary = 1000 WHERE DepartmentId = 1");
			
			int rows2 = ps.executeUpdate("UPDATE seller SET BaseSalary = 1000 WHERE DepartmentId = 2");
			
			conn.commit();
			
		}
		
		catch(SQLException e) {
			try {
				conn.rollback();
				System.out.println("transaction rolled back! Error: " + e.getMessage());
			}
			
			catch(SQLException e1) {
				System.out.println("error in rollback: " + e1.getMessage());
			}
			
		}
	}

}
