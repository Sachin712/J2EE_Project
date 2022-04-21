package model;

public class AddProduct {
	String deivceName, model, description;
	int deviceId;
	Double price;

	public AddProduct(int deviceId, String deivceName, String model, Double price, String description) {
		super();
		this.deivceName = deivceName;
		this.model = model;
		this.description = description;
		this.deviceId = deviceId;
		this.price = price;
	}

	public String getDeivceName() {
		return deivceName;
	}

	public void setDeivceName(String deivceName) {
		this.deivceName = deivceName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
