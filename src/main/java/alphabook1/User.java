package alphabook1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class User {
	private String first_name;
	private String last_name;
	private String gender;
	private long contact_number;
	private String dob;
	private String email_id;
	private String password;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	LocalDate date = null;
	String newStatus = "";
	Scanner scanner = new Scanner(System.in);

	public void postStatus() {
		date = LocalDate.now();
		System.out.println("enter your status hear");
		newStatus = scanner.nextLine();
		System.out.println(" your Status " + newStatus + "\n date " + date);

	}

	public void Profile(String email, User user) throws Exception {
		SocialMedia media = new SocialMedia();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL_ID=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("EMAIL ID        : " + resultSet.getString(1));
			System.out.println("FIRST NAME      : " + resultSet.getString(2));
			System.out.println("LAST NAME       : " + resultSet.getString(3));
			System.out.println("PASSWORD        : " + resultSet.getString(4));
			System.out.println("CONTACT  NUMBER : " + resultSet.getLong(5));
			System.out.println("GENDER          : " + resultSet.getString(6));
			System.out.println("DATE OF BIRTH   : " + resultSet.getString(7));
			System.out.println("------------------------");
		}
		connection.close();

	}
}
