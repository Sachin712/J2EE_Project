package model;

import java.time.LocalDate;

public class Device {
	private int deviceId;
	private String loginId, deviceName;
	private LocalDate purchaseDate;

	public Device(int deviceId, String loginId, String deviceName, LocalDate purchaseDate) {
		super();
		this.deviceId = deviceId;
		this.loginId = loginId;
		this.deviceName = deviceName;
		this.purchaseDate = purchaseDate;
	}

	public Device(String deviceName) {
		super();
		this.deviceName = deviceName;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
