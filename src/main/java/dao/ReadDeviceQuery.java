package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Device;

public class ReadDeviceQuery {
	Connection conn;
	ResultSet rs;

	public ReadDeviceQuery() {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead(String loginId) throws SQLException {
		String sql = "select * from register_device where loginId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, loginId);
		this.rs = st.executeQuery();
	}

	public void doReadAdmin() throws SQLException {
		String sql = "select * from register_device";
		PreparedStatement st = conn.prepareStatement(sql);
		this.rs = st.executeQuery();
	}

	public List<Device> list() throws SQLException {
		List<Device> listDevice = new ArrayList<>();

		String sql = "select * from available_devices";
		PreparedStatement st = conn.prepareStatement(sql);
		this.rs = st.executeQuery();

		while (this.rs.next()) {
			String deviceName = this.rs.getString("deviceName");
			Device dev = new Device(deviceName);
			listDevice.add(dev);

		}
		System.out.println(listDevice);
		return listDevice;
	}

	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>Device ID</th><th>Username</th><th>Device Name</th><th>PurchaseDate</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int id = this.rs.getInt("deviceId");
			String loginId = this.rs.getString("loginId");
			String deviceName = this.rs.getString("deviceName");
			Date pDate = (Date) this.rs.getObject("purchaseDate");
			LocalDate purchaseDate = pDate.toLocalDate();

			Device device = new Device(id, loginId, deviceName, purchaseDate);
			table += "<tr>";
			table += "<td>";
			table += "<a href='ReadClaim?deviceId=" + device.getDeviceId() + "&username=" + device.getLoginId() + "'>"
					+ device.getDeviceId() + "</a>";
			table += "</td>";
			table += "<td>";
			table += device.getLoginId();
			table += "</td>";
			table += "<td>";
			table += device.getDeviceName();
			table += "</td>";
			table += "<td>";
			table += device.getPurchaseDate();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

	public String getAdminHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>Device ID</th><th>Username</th><th>Device Name</th><th>PurchaseDate</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int id = this.rs.getInt("deviceId");
			String loginId = this.rs.getString("loginId");
			String deviceName = this.rs.getString("deviceName");
			Date pDate = (Date) this.rs.getObject("purchaseDate");
			LocalDate purchaseDate = pDate.toLocalDate();

			Device device = new Device(id, loginId, deviceName, purchaseDate);
			table += "<tr>";
			table += "<td>";
			table += "<a href='ReadClaimsAdmin?deviceId=" + device.getDeviceId() + "'>" + device.getDeviceId() + "</a>";
			table += "</td>";
			table += "<td>";
			table += device.getLoginId();
			table += "</td>";
			table += "<td>";
			table += device.getDeviceName();
			table += "</td>";
			table += "<td>";
			table += device.getPurchaseDate();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
