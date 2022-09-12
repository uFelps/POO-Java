package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import database.Database;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			conn = Database.getConnection();
			ps = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "Felipe Sandes");
			ps.setString(2, "felipesand824@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("17/06/2005").getTime()));
			ps.setDouble(4, 7000.0);
			ps.setInt(5, 3);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				rs = ps.getGeneratedKeys();
				System.out.println("Done! Rows Afected: " + rows);
				System.out.println("User added: ");
				
				while(rs.next()) {
					System.out.println("Id: " + rs.getInt(1));
				}
			}
		}
		
		catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		finally {
			Database.closeConnection();
			Database.closeResultSet(rs);
			Database.closeStatement(ps);
		}
	}

}
