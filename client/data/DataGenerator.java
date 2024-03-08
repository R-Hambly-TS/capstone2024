package cap.client.data;

import cap.client.model.DefaultIOTData;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;

public class DataGenerator {
	
	// Constructor
	public DataGenerator() {
		
	}
	
	// Generate Data Function
	DefaultIOTData generateData(String deviceid, String devicetype) {
		// Create newEntry object
		DefaultIOTData newEntry = new DefaultIOTData();
		// Set IOTData values
		newEntry.setDeviceID(deviceid);
		newEntry.setTransmissionTime(LocalDateTime.now());
		newEntry.setDeviceType(devicetype);
		
		// Generate a data string based on device type
		
		if (newEntry.getDeviceType() == "thermostat") {
			// Generate value between 12.0 and 25.0
			double minTemp = 12.0;
			double maxTemp = 25.0;
			double randomTemp = Math.floor(Math.random() *(maxTemp - minTemp + 1) + minTemp);
			
			newEntry.setData(Double.toString(randomTemp));
			
			
		} else if (newEntry.getDeviceType() == "audioplayer") {
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
			int randomListIndex = (int)Math.floor(Math.random() *(maxList - minList + 1) + minList);
			
			// Chance for no song
			Random randomNum = new Random();
			int noSongChance = randomNum.nextInt(10);
			
			if(noSongChance == 0) {
				newEntry.setData("Error: No Song Found");
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
