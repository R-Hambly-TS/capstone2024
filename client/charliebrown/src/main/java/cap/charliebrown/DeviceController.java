package cap.charliebrown;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import cap.snoopy.DefaultIOTData;
import cap.snoopy.DataService;
import cap.snoopy.DataRepository;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
	// Global functions
	private final String snoopyURL = "http://localhost:8080/api/entries";
	private final WebClient webClient = WebClient.create();
	
	@PostMapping("/sendData")
	public Mono<String> sendData(@RequestBody DefaultIOTData data){
		// Format data
		// Setting Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Send Data to Server via POST
		return webClient.post()
				.uri(snoopyURL)
				.headers(httpHeaders -> httpHeaders.addAll(headers))
				.body(BodyInserters.fromValue(data))
				.retrieve()
				.bodyToMono(String.class)
				.doOnSuccess(response -> {
					// Log response
				})
				.onErrorResume(throwable -> {
					// Handle error response
					throwable.printStackTrace(); // Log exception
					return Mono.just("Error sending data to server");
				});
		
		dataService.saveData(data);
		
	}
}
