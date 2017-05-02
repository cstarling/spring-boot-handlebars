package hello;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    //http://stackoverflow.com/questions/30312058/spring-boot-how-to-get-the-running-port
    @LocalServerPort
    private int port;

    @Test
    public void renderTemplate() throws Exception {
        // given
        URL helloPage = new URL("http://localhost:" + port);

        // when
        String responseBody = Resources.toString(helloPage, Charsets.UTF_8);

        // then
        assertThat(responseBody, containsString("<title>Hello World!</title>"));
    }
}