package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AddProduct;

public class ReadProductQuery {
	Connection conn;
	ResultSet rs;

	public ReadProductQuery() throws ClassNotFoundException, SQLException {

		// conn = [call your static DB method]
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead() throws SQLException {
		String sql = "select * from available_devices";
		PreparedStatement st = conn.prepareStatement(sql);
		this.rs = st.executeQuery();
	}

	public void doDelete(int deviceId) throws SQLException {
		String sql = "DELETE FROM heroku_b89caede66a73b0.available_devices WHERE deviceId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, deviceId);
		st.executeUpdate();
		doRead();
	}

	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>ID</th><th>Device Name</th><th>Model</th><th>Price</th><th>Description</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int id = this.rs.getInt("deviceId");
			String deviceName = this.rs.getString("deviceName");
			String model = this.rs.getString("model");
			Double price = this.rs.getDouble("price");
			String description = this.rs.getString("description");

			AddProduct prod = new AddProduct(id, deviceName, model, price, description);
			table += "<tr>";
			table += "<td>";
			table += "<a href='updateProduct.jsp?deviceId=" + prod.getDeviceId() + "&deviceName=" + prod.getDeivceName()
					+ "&model=" + prod.getModel() + "&price=" + prod.getPrice() + "&description="
					+ prod.getDescription() + "'>" + prod.getDeviceId() + "</a>";
			table += "</td>";
			table += "<td>";
			table += prod.getDeivceName();
			table += "</td>";
			table += "<td>";
			table += prod.getModel();
			table += "</td>";
			table += "<td>";
			table += prod.getPrice();
			table += "</td>";
			table += "<td>";
			table += prod.getDescription();
			table += "</td>";
		}
		return table;
	}

	public String getDeleteHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>ID</th><th>Device Name</th><th>Model</th><th>Price</th><th>Description</th><th>Delete</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int id = this.rs.getInt("deviceId");
			String deviceName = this.rs.getString("deviceName");
			String model = this.rs.getString("model");
			Double price = this.rs.getDouble("price");
			String description = this.rs.getString("description");

			AddProduct prod = new AddProduct(id, deviceName, model, price, description);
			table += "<tr>";
			table += "<td>";
			table += prod.getDeviceId();
			table += "</td>";
			table += "<td>";
			table += prod.getDeivceName();
			table += "</td>";
			table += "<td>";
			table += prod.getModel();
			table += "</td>";
			table += "<td>";
			table += prod.getPrice();
			table += "</td>";
			table += "<td>";
			table += prod.getDescription();
			table += "</td>";
			table += "<td>";
			table += "<a href='ReadAddProduct?action=delete&deviceId=" + prod.getDeviceId() + "'>Delete</a>";
			table += "</td>";

		}
		return table;
	}
}
