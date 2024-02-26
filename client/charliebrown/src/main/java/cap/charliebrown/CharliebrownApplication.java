package cap.charliebrown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "cap.snoopy")
@EnableScheduling
public class CharliebrownApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharliebrownApplication.class, args);
	}

}
