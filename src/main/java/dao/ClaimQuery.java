package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Claim;

public class ClaimQuery {

	Connection conn;
	ResultSet rs;

	public ClaimQuery() {
		try {
			conn = DB.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead(int deviceId) throws SQLException {
		String sql = "select * from add_claim where deviceId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, deviceId);
		this.rs = st.executeQuery();
		//return this.rs;
	}

	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>Caim ID</th><th>Device ID</th><th>Date of Claim</th><th>Description</th><th>Approved</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int cid = this.rs.getInt("claimId");
			int loginId = this.rs.getInt("deviceId");
			Date cDate = (Date) this.rs.getObject("dateOfClaim");
			LocalDate claimDate = cDate.toLocalDate();
			String desc = this.rs.getString("description");
			String approved = this.rs.getString("approved");

			Claim claim = new Claim(cid, loginId, desc, claimDate, approved);
			table += "<tr>";
			table += "<td>";
			table += claim.getClaimId();
			table += "</td>";
			table += "<td>";
			table += claim.getDeviceId();
			table += "</td>";
			table += "<td>";
			table += claim.getDescription();
			table += "</td>";
			table += "<td>";
			table += claim.getDateOfClaim();
			table += "</td>";
			table += "<td>";
			table += claim.getApproved();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

	public String getAdminHTMLTable() throws SQLException {
		String table = "";
		table += "<form action='ReadDeviceAdmin' method='get'><table class='table'>";
		table += "<thead class = 'table-dark'><tr><th>Caim ID</th><th>Device ID</th><th>Date of Claim</th><th>Description</th><th>Approved</th></tr></thead>";
		table += "<tbody>";

		while (this.rs.next()) {
			int cid = this.rs.getInt("claimId");
			int loginId = this.rs.getInt("deviceId");
			Date cDate = (Date) this.rs.getObject("dateOfClaim");
			LocalDate claimDate = cDate.toLocalDate();
			String desc = this.rs.getString("description");
			String approved = this.rs.getString("approved");

			Claim claim = new Claim(cid, loginId, desc, claimDate, approved);
			table += "<tr>";
			table += "<td>";
			table += claim.getClaimId();
			table += "</td>";
			table += "<td>";
			table += claim.getDeviceId();
			table += "</td>";
			table += "<td>";
			table += claim.getDescription();
			table += "</td>";
			table += "<td>";
			table += claim.getDateOfClaim();
			table += "</td>";
			table += "<td>";
			table +="<input type='checkbox' name='"+claim.getClaimId()+"' />";
			table += "</td>";
			table += "</tr>";
		}
		table+="</tbody></table>";
		table +="<button type='submit' class='btn btn-dark float-right'>SUBMIT</button>";
		table+="</form>";
		return table;
	}
}
