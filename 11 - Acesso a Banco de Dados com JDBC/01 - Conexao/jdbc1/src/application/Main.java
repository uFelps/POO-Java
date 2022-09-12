package application;

import java.sql.Connection;

import db.Database;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = Database.getConnection();
		Database.closeConnection();
	}

}
