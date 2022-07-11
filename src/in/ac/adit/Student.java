package in.ac.adit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private final static String URL = "jdbc:mysql://localhost:3306/student_db";
	private final static String USERNAME = "root";
	private final static String USERPASSWORD = "";
	private Connection con = null;
	private PreparedStatement pstat = null;
	
	public Student() {
		try {
			con = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean add() {
		boolean result = false;
		try {
			pstat = con.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?, ?);");
			pstat.setInt(1, 1);
			pstat.setString(2, "ABHI");
			pstat.setString(3, "abhi02.trivedi@gmail.com");
			pstat.setString(4, "ITA8a");
			result = pstat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update() {
		try {
			pstat = con.prepareStatement("UPDATE STUDENT SET NAME = ? WHERE ID = ?;");
			pstat.setString(1, "ABHI TRIVEDI");
			pstat.setInt(2, 1);
			return pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void view() {
		try {
			pstat = con.prepareCall("SELECT * FROM STUDENT WHERE ID = 1;");
			ResultSet rs = pstat.getResultSet();
			System.out.println("Id: " +rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
