package cap.client.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

import org.springframework.stereotype.Component;

import cap.server.model.DefaultIOTData;

@Component
public class DataGenerator {
	
	// HashMap to store the previous value of temperatures for a thermostat device to check for abnormal data
	private Map<String,Double> previousTemps = new HashMap<>();
	
	// Constructor
	public DataGenerator() {
		
	}
	
	// Generate Data Function
	public DefaultIOTData generateData(String deviceid, String devicetype) {
		// Create newEntry object
		DefaultIOTData newEntry = new DefaultIOTData();
		// Set IOTData values
		newEntry.setDeviceID(deviceid);
		newEntry.setTransmissionTime(LocalDateTime.now());
		newEntry.setDeviceType(devicetype);
		newEntry.setDataStatus("normal");
		
		// Generate a data string based on device type
		if ("thermostat".equals(newEntry.getDeviceType())) {
			// Generate value between 12.0 and 25.0
			double minTemp = 12.0;
			double maxTemp = 25.0;
			double randomTemp = Math.floor(Math.random() *(maxTemp - minTemp + 1) + minTemp);
			
			// Checking for abnormal temperature range
			if (previousTemps.containsKey(deviceid)) {
				double prevTemp = previousTemps.get(deviceid);
				// Check if there is a more than 5.0 degree jump in temperature
				if (Math.abs(randomTemp - prevTemp) > 5.0) {
					newEntry.setDataStatus("abnormal");
				}
			}
			// Set Data
			newEntry.setData(Double.toString(randomTemp));
			// Update previousTemps value for specified deviceID
			previousTemps.put(deviceid, randomTemp);
			
			
		} else if ("audioplayer".equals(newEntry.getDeviceType())) {
			// List of possible songs to be played
			int songListLen = 10;
			ArrayList<String> songList = new ArrayList<String>(songListLen);
			songList.add("Everybody by Backstreet Boys");
			songList.add("I Want It That Way by Backstreet Boys");
			songList.add("Smells Like Teen Spirit by Nirvana");
			songList.add("Come Together by The Beatles");
			songList.add("Hey Ya! by Outkast");
			songList.add("Basket Case by Green Day");
			songList.add("Don't Stop Believin by Journey");
			songList.add("Waterfalls by TLC");
			songList.add("Tiny Dancer by Elton John");
			songList.add("Seven Nation Army by The White Stripes");
			
			// Select a random entry from the list of songs
			int minList = 0;
			int maxList = 10;
			Random random = new Random();
			int randomListIndex = random.nextInt(maxList - minList) + minList;
			
			// Chance for no song
			Random randomNum = new Random();
			int noSongChance = randomNum.nextInt(20);
			
			if(noSongChance == 0) {
				newEntry.setData("Error: No Song Found");
				newEntry.setDataStatus("abnormal");
			} else {
				newEntry.setData(songList.get(randomListIndex));
			}
			
		} else {
			// Generate a default random data string
			newEntry.setData("data-entry-info");
			
		}
		
		return newEntry;
		
	}
}
