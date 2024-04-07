package cap.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class IOTDevice {
	// ID for data transmission
	private @Id @GeneratedValue Long id;
	
	private String deviceID;
	
	private String deviceType;

	
	// Constructors
	public IOTDevice() {
		
	}
	
	public IOTDevice(String deviceid, String devicetype){
		this.deviceID = deviceid;
		this.deviceType = devicetype;
	}
	
	// Getters
	public String getDeviceID() {
		return this.deviceID;
	}
	
	public String getDeviceType() {
		return this.deviceType;
	}
	
	// Setters
	public void setDeviceID(String deviceid) {
		this.deviceID = deviceid;
	}
	
	public void setDeviceType(String devicetype) {
		this.deviceType = devicetype;
	}
	
	
}
