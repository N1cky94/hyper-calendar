package webCalendarSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private List<Event> listOfEvents = new ArrayList<>();

    public EventCreatedDto createNewEvent(Event event) {
        listOfEvents.add(event);

        return EventCreatedDto.from(event);
    }
}
