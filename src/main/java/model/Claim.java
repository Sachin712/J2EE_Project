package model;

import java.time.LocalDate;

public class Claim {
	private int claimId, deviceId;
	private String description, approved;
	private LocalDate dateOfClaim;

	public Claim(int claimId, int deviceId, String description, LocalDate dateOfClaim, String approved) {
		super();
		this.claimId = claimId;
		this.deviceId = deviceId;
		this.description = description;
		this.dateOfClaim = dateOfClaim;
		this.approved=approved;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(LocalDate dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

}
