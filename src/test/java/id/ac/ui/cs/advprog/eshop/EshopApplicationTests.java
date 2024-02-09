package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        useMainMethod = SpringBootTest.UseMainMethod.ALWAYS
)
class EshopApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void main() {}

    @Test
    void testHomePage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Welcome");
    }


}
