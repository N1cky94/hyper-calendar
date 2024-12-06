package webCalendarSpring;

import java.time.LocalDate;

public record EventCreatedDto(String message, String event, String date) {
    public static EventCreatedDto from(Event event) {
        return new EventCreatedDto(
                "The event has been added!",
                event.getEvent(),
                event.getDate().toString()
        );
    }
}
