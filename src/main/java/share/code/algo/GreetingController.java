package share.code.algo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok("hello "+name);
    }
}

