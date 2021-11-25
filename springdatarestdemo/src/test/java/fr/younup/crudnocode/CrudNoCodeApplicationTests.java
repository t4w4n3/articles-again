package fr.younup.crudnocode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
class CrudNoCodeApplicationTests {

	@Test
	void contextLoads() throws URISyntaxException, IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/livres"))
				.GET()
				.build();
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		var one = 1;
	}

}
