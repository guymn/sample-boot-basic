package th.mfu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Test
    public void testHello() {
        // Act
        String response = controller.hello();
        // Assert
        assertEquals("Hello World!", response);
    }

    @Test
    public void testHiName() {
        String response = controller.hiName("var");
        assertEquals("Hello var", response);
    }

    @Test
    public void testSum(){
        int response = controller.sum(5, 10);
        assertEquals(15,response);
    }
}
