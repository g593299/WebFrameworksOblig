package oblig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import oblig.model.Item;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebFrameworkGroup2ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	TestRestTemplate template;
	
	@Test
	public void checkIf3Items() throws Exception {
	 //TODO
	}
	
	@Test
	public void checkIf10100isNotFound() throws Exception {
		//TODO
	}

}
