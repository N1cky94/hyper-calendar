package webCalendarSpring;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("event")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam("start_date") Optional<LocalDate> startDate, @RequestParam("end_date") Optional<LocalDate> endDate) {
        var events = service.getAllEvents();

        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        if (startDate.isPresent() && endDate.isPresent()) {
            events = events.stream()
                    .filter(e -> e.getDate().isAfter(startDate.get()) && e.getDate().isBefore(endDate.get()))
                    .toList();
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
