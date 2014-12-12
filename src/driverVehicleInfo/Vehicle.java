package driverVehicleInfo;

public class Vehicle {
	private String vehicleId;
	private String name;
	
	public String getVehicleId() {
		return vehicleId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.vehicleId + " : " + 
			this.name;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}
