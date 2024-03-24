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
	private int port;
	
	// Constructors
	public IOTDevice(int port) {
		this.port = port;
	}
	
	public IOTDevice(String deviceid, String devicetype, int port){
		this.deviceID = deviceid;
		this.deviceType = devicetype;
		this.port = port;
	}
	
	
	// Getters
	public String getDeviceID() {
		return this.deviceID;
	}
	
	public String getDeviceType() {
		return this.deviceID;
	}
	
	public int getPort() {
		return this.port;
	}
	
	// Setters
	public void setDeviceID(String deviceid) {
		this.deviceID = deviceid;
	}
	
	public void setDeviceType(String devicetype) {
		this.deviceType = devicetype;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
