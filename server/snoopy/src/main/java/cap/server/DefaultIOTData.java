package cap.server.model;

import java.util.Objects;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DefaultIOTData {
	// ID for data transmission
	private @Id @GeneratedValue Long id;
	
	// ID of transmitting device
	private String deviceID;
	private String deviceType;
	private String data;
	private LocalDateTime transmissionTime;

	// Constructor with no parameters
	public DefaultIOTData() {}

	// Constructor with basic parameters
	public DefaultIOTData(String deviceid,String devicetype, String data){
		this.deviceID = deviceid;
		this.deviceType = devicetype;
		this.data = data;
	}
	
	// Getters
	
	public Long getID() {
		return this.id;
	}
	
	public String getDeviceID() {
		return this.deviceID;
	}
	
	public String getDeviceType() {
		return this.deviceType;
	}
	
	public String getData() {
		return this.data;
	}
	
	public LocalDateTime getTransmissionTime() {
		return this.transmissionTime;
	}
	
	// Setters
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public void setDeviceID(String devID) {
		this.deviceID = devID;
	}
	
	public void setDeviceType(String devtype) {
		this.deviceType = devtype;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setTransmissionTime(LocalDateTime transmissiontime) {
		this.transmissionTime = transmissiontime;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DefaultIOTData))
			return false;
		DefaultIOTData entry = (DefaultIOTData) o;
		return Objects.equals(this.id, entry.id) && Objects.equals(this.data, entry.data);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id,this.data);
	}
	
	@Override public String toString() {
		return "Data{" + "deviceID=" + this.deviceID + ", deviceType=" + this.deviceType + ", data='" + this.data + "\'" + "}";
	}

}

