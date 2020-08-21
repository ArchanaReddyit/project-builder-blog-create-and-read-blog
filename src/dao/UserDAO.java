package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	public int signUp(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO USERS(email, password)VALUES(?,?)";

		int result = 0;
		try
		{
			 Connection con=null;
			   con=ConnectionManager.getConnection();
			
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public boolean loginUser(User user) throws ClassNotFoundException {
		
		try{
			 Connection con=null;
			   con=ConnectionManager.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement("select * from users where email = ? and password = ? ");
		
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			 System.out.println(rs.next());
			//status = rs.next();
              // System.out.println(status);
			 return true;
		} catch (SQLException e) {
			// process sql exception
			System.out.println(e);
		}
		return false;
	}

}
