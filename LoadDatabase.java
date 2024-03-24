package cap.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cap.server.model.DefaultIOTData;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(DataRepository repository ) {
		return args -> {
			log.info("Preloading: " + repository.save(new DefaultIOTData("thermostat-01", "thermostat", "1234")));
			log.info("Preloading: " + repository.save(new DefaultIOTData("audio-01", "audioplayer", "5678")));
		};
	}
}
