package cap.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "cap")
public class SnoopyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SnoopyApplication.class, args);

		
	}
}

	