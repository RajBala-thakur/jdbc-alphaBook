package alphabook1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SocialMedia {
 Connection connection = new ConnectionObject().getConnection();
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	public void signUp(User user) throws Exception
	{
		
		String query= "insert into USER value(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setString(1, user.getEmail_id());
		preparedStatement.setString(2, user.getFirst_name());
		preparedStatement.setString(3, user.getLast_name());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setLong(5, user.getContact_number());
		preparedStatement.setString(6, user.getGender());
		preparedStatement.setString(7, user.getDob());
		preparedStatement.executeUpdate();
		connection.close();
		System.out.println("==========Signup Successfull=========");
				
	}
	
	public void logIn(String email,String password,User user) throws Exception
	{
		String query="select * from user where email_id=? and password=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getEmail_id());
		preparedStatement.setString(2, user.getPassword());
		
		ResultSet resultset= preparedStatement.executeQuery();
		String passd="";
		String emaild="";
		
		while(resultset.next())
		{
			emaild=resultset.getString(1);
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			passd=resultset.getString(4);
		System.out.println(resultset.getString(4));
			System.out.println(resultset.getLong(5));
			System.out.println(resultset.getString(6));
			System.out.println(resultset.getString(7));
				
		}
		if(passd.equals(user.getPassword()) && emaild.equals(user.getEmail_id()))
		{
			System.out.println("******You are logged in successfully******");
			
		}
		else
		{
			System.out.println("******Invalid Id or Password*****");
		}
		connection.close();
	}

}
