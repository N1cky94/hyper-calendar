package webCalendarSpring;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepo;

    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    public EventCreatedDto createNewEvent(CreateEventCommand eventCommand) {
        Event newEvent = eventCommand.toEvent();
        eventRepo.save(newEvent);
        return EventCreatedDto.from(newEvent);
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public List<Event> getEventsForToday() {
        LocalDate today = LocalDate.now();
        return eventRepo.findByDate(today);
    }
}
