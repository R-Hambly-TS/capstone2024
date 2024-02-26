package cap.charliebrown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import cap.snoopy.DataService;
import cap.snoopy.DefaultIOTData;

@Service
public class DeviceService {
	
	private final DeviceController deviceController;
	private final DataService dataService;
	
	@Autowired
	public DeviceService(DeviceController deviceController, DataService dataService) {
		this.deviceController = deviceController;
		this.dataService = dataService;
	}
	
	@Scheduled(fixedRate = 90000) // Runs every 90 seconds
	public void scheduleSendData() {
		// Logic to gather and format data
		DefaultIOTData data = new DefaultIOTData("deviceID3", "sampledata");
		
		// Send data to server via POST requests
		deviceController.sendData(data);
		
		// Save data to repository;
		dataService.saveData(data);
		
		System.out.println("Scheduled task executed at " + LocalDateTime.now());
		
	}
}
