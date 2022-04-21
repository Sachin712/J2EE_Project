package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private Connection conn;
	ResultSet rs;

	public LoginDao() {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String login(String username, String password) throws SQLException {
		String sql = "select username, password from heroku_b89caede66a73b0.user where username=? and password=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);

		this.rs = st.executeQuery();

		if (this.rs.next())
			return "success";

		return "failure";

	}

}
