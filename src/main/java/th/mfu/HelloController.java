package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    String hello() {
        return "Hello World!";
    }

    @GetMapping("/hi/{name}")
    String hiName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/sum/{a}/{b}")
    int sum(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    public String s(int i, int j) {
        return null;
    }
}
