package cap.snoopy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(DataRepository repository ) {
		return args -> {
			log.info("Preloading: " + repository.save(new DefaultIOTData("device1", "1234")));
			log.info("Preloading: " + repository.save(new DefaultIOTData("device2", "5678")));
		};
	}
}
