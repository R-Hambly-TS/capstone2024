package cap.client.data;

import cap.server.model.DefaultIOTData;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

@Component
public class DataSender {
	
	// Constructor 
	public DataSender() {
		
	}
	
	// Server URL
	String serverURL = "http://localhost:8088/entries";
	private final String serverHost = "localhost";
	private final int serverPort = 8088;
	private final WebClient webClient = WebClient.create();
	
	// Send Data via HTTP Function
	public void sendHTTPData(DefaultIOTData newEntry) {
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Create HTTPEntity w DefaultIOTData object + header
		HttpEntity<DefaultIOTData> requestEntity = new HttpEntity<>(newEntry, headers);
		
		// Send POST request via WebClient
		webClient.post()
				.uri(serverURL)
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(requestEntity))
				.retrieve()
				.bodyToMono(String.class)
				.subscribe(response -> {
					// Handle response
					System.out.println("Server Response: " + response);
				});	
		
	}
	
	// Send Data via Socket Function
	public void sendSocketData(DefaultIOTData newEntry) {
		try(Socket serverSocket = new Socket(serverHost, serverPort);
			OutputStream outputStream = serverSocket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
			
			objectOutputStream.writeObject(newEntry);
			objectOutputStream.flush();
			
			System.out.println("Socket Server Response: Data sent successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
