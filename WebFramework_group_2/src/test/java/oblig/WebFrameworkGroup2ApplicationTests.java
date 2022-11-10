package oblig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import oblig.model.Item;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebFrameworkGroup2ApplicationTests {
	
	@Autowired
	TestRestTemplate template;
	
	@Test
	public void checkIf3Items() throws Exception {
	 //TODO
	}
	
	@Test
	public void checkIf10100isNotFound() throws Exception {
		
		//TODO
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpStatus expectedStatus = HttpStatus.NOT_FOUND;
//		
//		Item i = new Item();
//		i.setId("10100");
//		i.setName("Test");
//		i.setPrice(1.0);
//		i.setDescription("Testing");
//		
//		String url = "/items/" + i.getId();
//		HttpEntity<Item> requestUpdate = new HttpEntity<>(i, headers);
//		ResponseEntity<Item> response = template.exchange(url, HttpMethod.GET, requestUpdate, Item.class);
//	
//		assertEquals(expectedStatus, response.getStatusCode());

		
	}

}
