package driverVehicleInfo;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	private String driverId;
	private String name;
	
	public List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public String getDriverId() {
		return driverId;
	}
	
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.driverId + " : " + 
				this.name	+  " : " +
				this.vehicles;
	}
}
