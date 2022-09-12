package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Database;
import database.DbIntegratyException;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Database.getConnection();
			ps = conn.prepareStatement("DELETE FROM department WHERE (Id = ?)");
			
			ps.setInt(1, 1);
			
			int rows = ps.executeUpdate();
			
			System.out.println("Done! Rows afected: " + rows);
		}
		
		catch(SQLException e) {
			throw new DbIntegratyException(e.getMessage());
		}
	}

}
