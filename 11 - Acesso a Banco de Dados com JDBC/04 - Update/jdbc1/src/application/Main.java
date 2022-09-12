package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Database;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Database.getConnection();
			
			ps = conn.prepareStatement("UPDATE seller SET BaseSalary = (BaseSalary + ?) WHERE (Id = ?)");
			
			ps.setDouble(1, 5000.0);
			ps.setInt(2, 9);
			
			int rows = ps.executeUpdate();
			
			System.out.println("Done! Rows Afected: " + rows);
			
		}
		catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
