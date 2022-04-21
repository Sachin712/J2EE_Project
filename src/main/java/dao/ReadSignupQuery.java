package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class ReadSignupQuery {
	Connection conn;
	ResultSet rs;

	public ReadSignupQuery() throws ClassNotFoundException, SQLException {

		// conn = [call your static DB method]
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead() throws SQLException {
		String sql = "select * from user";
		PreparedStatement st = conn.prepareStatement(sql);
		this.rs = st.executeQuery();
	}

	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>ID</th><th>Fullname</th><th>Username</th><th>Password</th><th>Phone Number</th><th>Email</th><th>Address</th></tr></thead>";
		table+="<tbody>";
		
		while (this.rs.next()) {
			int id = this.rs.getInt("uid");
			String fullname = this.rs.getString("fullname");
			String username = this.rs.getString("username");
			String password = this.rs.getString("password");
			String phoneNumber = this.rs.getString("phoneNumber");
			String email = this.rs.getString("email");
			String address = this.rs.getString("address");

			User user = new User(id, fullname, username, password, phoneNumber, email, address);
			table += "<tr>";
			table += "<td>";
			table += user.getUserID();
			table += "</td>";
			table += "<td>";
			table += user.getFullname();
			table += "</td>";
			table += "<td>";
			table += user.getUsername();
			table += "</td>";
			table += "<td>";
			table += user.getPassword();
			table += "</td>";
			table += "<td>";
			table += user.getPhone();
			table += "</td>";
			table += "<td>";
			table += user.getEmail();
			table += "</td>";
			table += "<td>";
			table += user.getAddress();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
