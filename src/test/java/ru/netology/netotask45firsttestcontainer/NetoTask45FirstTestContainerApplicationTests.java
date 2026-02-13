package ru.netology.netotask45firsttestcontainer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.testcontainers.containers.wait.strategy.Wait.forHttp;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NetoTask45FirstTestContainerApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> myAppFirst = new GenericContainer<>("task45:1.0")
            .withExposedPorts(8080)
            .waitingFor(forHttp("/profile").forStatusCode(200));

    @Container
    private static final GenericContainer<?> myAppSecond = new GenericContainer<>("task45:2.0")
            .withExposedPorts(8080)
            .waitingFor(forHttp("/profile").forStatusCode(200));

    @Test
    void contextLoads() {
        Integer firstAppPort = myAppFirst.getMappedPort(8080);
        Integer secondAppPort = myAppSecond.getMappedPort(8080);

        ResponseEntity<String> entityFromFirst = restTemplate.getForEntity(
                "http://localhost:" + firstAppPort + "/profile", String.class);
        ResponseEntity<String> entityFromSecond = restTemplate.getForEntity(
                "http://localhost:" + secondAppPort + "/profile", String.class);

        System.out.println("First: " + entityFromFirst.getBody());
        System.out.println("Second: " + entityFromSecond.getBody());

        assert entityFromFirst.getBody().contains("dev");
        assert entityFromSecond.getBody().contains("production");
    }
}