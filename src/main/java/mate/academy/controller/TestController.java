package mate.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/say")
    public ResponseEntity<String> saySome() {
        return ResponseEntity.ok("Heeellloooooo");
    }

}
