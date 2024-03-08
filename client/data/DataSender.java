package cap.client.data;

import cap.client.model.DefaultIOTData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class DataSender {
	
	// Constructor 
	public DataSender() {
		
	}
	
	// Server URL
	String serverURL = "http://localhost:8088/entries";
	private final WebClient webClient = WebClient.create();
	
	// Send Data Function
	void sendData(DefaultIOTData newEntry) {
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Create HTTPEntity w DefaultIOTData object + header
		HttpEntity<DefaultIOTData> requestEntity = new HttpEntity<>(newEntry, headers);
		
		// Send POST request via WebClient
		webClient.post()
				.uri(serverURL)
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(newEntry))
				.retrieve()
				.bodyToMono(String.class)
				.subscribe(response -> {
					// Handle response
					System.out.println("Server Response: " + response);
				});	
	}

}
