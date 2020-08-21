package businesslogic;

//Type your code

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;

public class RegistrationValidation{

	public ConnectionManager add(User u, String conform) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String email = u.getEmail();
		String password = u.getPassword();
		ConnectionManager  con = new ConnectionManager();
		String sql ="insert into USERSIGNUP(email,password)VALUES(?,?)";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, password);
		ResultSet rs = st.executeQuery("select * from USERDETAILS");
		while(rs.next()) {
			if( password.equals(rs.getString("PASSWORD"))) {
				ConnectionManager.getConnection().close();
				return con;
			}
			else {
				ConnectionManager.getConnection().close();
				

				
			}
		st.executeUpdate();
		ConnectionManager.getConnection().close();
		
		
	}
		return con;
	
}
}