package webCalendarSpring;

import org.springframework.stereotype.Service;

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
}
