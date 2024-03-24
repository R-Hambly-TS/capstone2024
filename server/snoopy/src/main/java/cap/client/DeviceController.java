package cap.client;

import cap.server.model.DefaultIOTData;
import cap.client.data.DataGenerator;
import cap.client.model.IOTDevice;
import cap.server.DataRepository;
import cap.client.data.DataSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/entries")
@EnableScheduling
@Component
public class DeviceController {
	
	private final DataSender dataSender;
	private DataGenerator dataGenerator;
	private DataRepository dataRepository;

	
	@Autowired
	public DeviceController(DataSender datasender, DataGenerator datagenerator) {
		this.dataSender = datasender;
		this.dataGenerator = datagenerator;
	}
	
	// Start function to begin the execution of the newTransmission function
	@PostConstruct
	public void start() {
		// Device List
		ArrayList<IOTDevice> devices = createDeviceList();
		
		// Create ScheduledExecutorService
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(devices.size());
				
		// Scheduling transmissions based on each device
		for (IOTDevice device : devices) {
			scheduler.scheduleWithFixedDelay(() -> newTransmission(device), 0, 5000, TimeUnit.MILLISECONDS);
		}
	}
	
	// Creating the list of devices
	private ArrayList<IOTDevice> createDeviceList(){
		ArrayList<IOTDevice> devices = new ArrayList<>();
		devices.add(new IOTDevice("thermostat1","thermostat",8081));
		devices.add(new IOTDevice("thermostat2","thermostat",8082));
		devices.add(new IOTDevice("speaker1","audioplayer",8083));
		devices.add(new IOTDevice("speaker2","audioplayer",8084));
		devices.add(new IOTDevice("iot1","genericdevice",8085));
		
		return devices;
	}
	
	private DefaultIOTData newTransmission(IOTDevice device) {
		// Logic to generate data
		DefaultIOTData newEntry = dataGenerator.generateData(device.getDeviceID(),device.getDeviceType());
		
		// Logic to send data
		dataSender.sendHTTPData(newEntry);
		dataSender.sendSocketData(newEntry);
		
		
		// Save to Data Repository
		dataRepository.save(newEntry);
		
		return newEntry;
	}
	

}
