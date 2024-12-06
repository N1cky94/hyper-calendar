package webCalendarSpring;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("event")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("today")
    public ResponseEntity<List<Event>> getEventsForToday() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<EventCreatedDto> createNewEvent(@RequestBody @Valid CreateEventCommand event, BindingResult bResult) {
        EventCreatedDto result = service.createNewEvent(event);

        return ResponseEntity.ok(result);
    }
}
