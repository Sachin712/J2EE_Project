package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegDeviceDao {
	private Connection conn;

	public RegDeviceDao() {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int registerDevice(int deviceId, String loginId, String deviceName, LocalDate purchaseDate) {

		String sql = "INSERT INTO heroku_b89caede66a73b0.register_device (`deviceId`,`loginId`,`deviceName`,`purchaseDate`)VALUES(?,?,?,?)";
		PreparedStatement st;
		int temp = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deviceId);
			st.setString(2, loginId);
			st.setString(3, deviceName);
			st.setObject(4, purchaseDate);

			temp = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}

}
