package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClaimDao {
	private Connection conn;

	public ClaimDao() throws ClassNotFoundException, SQLException {
		// conn = [call your static DB method]
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addClaim(int deviceId, LocalDate dateOfClaim, String description, String approved) throws SQLException {
		String sql = "INSERT INTO heroku_b89caede66a73b0.add_claim(`claimId`,`deviceId`,`dateOfClaim`,`description`,`approved`)VALUES(default,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, deviceId);
		st.setObject(2, dateOfClaim);
		st.setString(3, description);
		st.setString(4, approved);

		int temp = st.executeUpdate();
		return temp;
		// System.out.println(temp);
	}

	public int approveClaim(int claimId) throws SQLException {
		String sql = "UPDATE heroku_b89caede66a73b0.add_claim SET `approved` = 'YES' WHERE `claimId` = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		try {
			st.setInt(1, claimId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp = st.executeUpdate();
		return temp;
	}
}