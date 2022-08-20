package entities;

public class Rent {
	private String studentName;
	private String email;
	private int room;

	// construtor
	public Rent(String studentName, String email, int room) {
		this.studentName = studentName;
		this.email = email;
		this.room = room;
	}

	public String toString() {
		return room + ": " + studentName + ", " + email;
	}
}