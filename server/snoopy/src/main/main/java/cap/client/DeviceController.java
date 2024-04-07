package cap.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.client.data.DataGenerator;
import cap.client.data.DataSender;
import cap.server.model.DefaultIOTData;
import cap.client.model.IOTDevice;
import cap.server.DataRepository;
import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/entries")
@EnableScheduling
@Component
public class DeviceController {
	
	private final DataSender dataSender;
	private DataGenerator dataGenerator;
	private DataRepository dataRepository;

	
	@Autowired
	public DeviceController(DataSender datasender, DataGenerator datagenerator, DataRepository datarepository) {
		this.dataSender = datasender;
		this.dataGenerator = datagenerator;
		this.dataRepository = datarepository;
	}
	
	// Start function to begin the execution of the newTransmission function
	@PostConstruct
	public void start() {
		// Device List
		ArrayList<IOTDevice> devices = createDeviceList();
		
		// Do-While Loop that creates a new transmission for each device 50 times.
		int i = 0;
		do {
			for(IOTDevice device : devices) {
				newTransmission(device);
			}
			
			i++;
		}while (i <= 50);
	}
	
	// Creating the list of devices
	private ArrayList<IOTDevice> createDeviceList(){
		ArrayList<IOTDevice> devices = new ArrayList<>();
		devices.add(new IOTDevice("thermostat1","thermostat"));
		devices.add(new IOTDevice("thermostat2","thermostat"));
		devices.add(new IOTDevice("speaker1","audioplayer"));
		devices.add(new IOTDevice("speaker2","audioplayer"));
		devices.add(new IOTDevice("iot1","genericdevice"));
		
		return devices;
	}
	
	// Method for creating a new data transmission
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
