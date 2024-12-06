package webCalendarSpring;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("event")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        var events = service.getAllEvents();

        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(events);
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        var event = service.getEventById(id);

        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventCreatedDto> createNewEvent(@RequestBody @Valid CreateEventCommand event, BindingResult bResult) {
        EventCreatedDto result = service.createNewEvent(event);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable Integer id) {
        var event = service.removeEventById(id);

        return ResponseEntity.ok(event);
    }

    @GetMapping("today")
    public ResponseEntity<List<Event>> getEventsForToday() {
        var events = service.getEventsForToday();

        return ResponseEntity.ok(events);
    }
}
