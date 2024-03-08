package cap.client;

import cap.client.data.DataSender;
import cap.client.model.DefaultIOTData;
import cap.client.data.DataGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.task.TaskExecutor;


@RestController
@RequestMapping("/devices")
@EnableScheduling
@Configuration
public class DeviceController {
	
	private final DataSender dataSender;
	private TaskExecutor taskExecutor;
	
	@Autowired
	public DeviceController(DataSender datasender) {
		this.dataSender = datasender;
	}
	
	// Client Device Creation
	@PostMapping("/{port}")
	@Scheduled(fixedDelay=5000)
	public ResponseEntity<String> createDevice(@PathVariable int port){
		
		
		
	}
	
	// Logic to periodically generate data
	
	
	// Logic to check if the value is abnormal
	
	// If value is abnormal, send alert
	
}
