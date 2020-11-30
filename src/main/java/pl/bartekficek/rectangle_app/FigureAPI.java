package pl.bartekficek.rectangle_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureAPI {

    @GetMapping("/calculate")
    public int calculate(@RequestParam String figure, @RequestParam int sideA, @RequestParam int sideB, @RequestParam(required = false) Integer sideC) {
        if (figure.equalsIgnoreCase("TRIANGLE")) {
            return sideA + sideB + sideC;
        } else if (figure.equalsIgnoreCase("RECTANGLE")) {
            return 2 * sideA + 2 * sideB;
        }
        return 0;
    }
}
