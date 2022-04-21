package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductDao {
	private Connection conn;

	public AddProductDao() throws ClassNotFoundException, SQLException {
		// conn = [call your static DB method]
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addProduct(String deviceName, String model, Double price, String description) throws SQLException {
		String sql = "INSERT INTO heroku_b89caede66a73b0.available_devices(`deviceId`,`deviceName`,`model`,`price`,`description`)VALUES(default,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, deviceName);
		st.setString(2, model);
		st.setDouble(3, price);
		st.setString(4, description);

		int temp = st.executeUpdate();
		return temp;
		// System.out.println(temp);
	}

	public int updateProduct(int deviceId, String deviceName, String model, Double price, String description)
			throws SQLException {
		String sql = "UPDATE `j2ee_project`.`available_devices`SET`deviceName` =?,`model` = ?,`price` = ?,`description` =? WHERE `deviceId` = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, deviceName);
		st.setString(2, model);
		st.setDouble(3, price);
		st.setString(4, description);
		st.setInt(5, deviceId);

		int temp = st.executeUpdate();
		return temp;
		// System.out.println(temp);
	}

}
