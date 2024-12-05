package webCalendarSpring;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    @GetMapping("today")
    public ResponseEntity<List<Event>> getEventsForToday() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(200));
    }

    public record Event() {}
}
