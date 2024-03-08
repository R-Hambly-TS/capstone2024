package cap.client.model;

import java.util.Objects;
import java.time.LocalDateTime;

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
	IOTDevice() {
		
	}
	
	IOTDevice(String deviceid, String devicetype){
		this.deviceID = deviceid;
		this.deviceType = devicetype;
	}
	
	// Getters
	String getDeviceID() {
		return this.deviceID;
	}
	
	String getDeviceType() {
		return this.deviceID;
	}
	
	// Setters
	void setDeviceID(String deviceid) {
		this.deviceID = deviceid;
	}
	
	void setDeviceType(String devicetype) {
		this.deviceType = devicetype;
	}
	
	
}
