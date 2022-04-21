package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupDao {

	private Connection conn;

	public SignupDao() throws ClassNotFoundException, SQLException {
		// conn = [call your static DB method]
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int signup(String fullname, String username, String password, String phoneNumber, String email,
			String address) throws SQLException {
		String sql = "INSERT INTO heroku_b89caede66a73b0.user (`uid`,`fullname`,`username`,`password`,`phoneNumber`,`email`,`address`)VALUES(default,?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, fullname);
		st.setString(2, username);
		st.setString(3, password);
		st.setString(4, phoneNumber);
		st.setString(5, email);
		st.setString(6, address);

		int temp = st.executeUpdate();
		return temp;
		//System.out.println(temp);
	}

}
